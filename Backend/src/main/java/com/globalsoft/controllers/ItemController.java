package com.globalsoft.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalsoft.constants.GenericConstants;
import com.globalsoft.constants.UrlConstants;
import com.globalsoft.dao.UserItemMappingRepository;
import com.globalsoft.dao.UserRepository;
import com.globalsoft.dto.models.UserItemCompositeId;
import com.globalsoft.dto.models.UserItemMapping;
import com.globalsoft.generic.models.FetchCreatedItemRequest;
import com.globalsoft.generic.models.FetchCreatedItemResponse;
import com.globalsoft.generic.models.ItemCreationRequest;
import com.globalsoft.generic.models.ItemCreationResponse;
import com.globalsoft.services.HTTPClientService;
import com.globalsoft.services.ItemService;
import com.google.gson.Gson;

@RestController
public class ItemController {
//	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private UserItemMappingRepository userItemMappingRepository;
	@Autowired
	private HTTPClientService httpClientService;
	@Autowired
	private ItemService itemService;

	private static final Logger LOGGER = Logger.getLogger(ItemController.class.getName());

	@GetMapping("/check")
	public List<UserItemMapping> showMessage() {
//		List<User> users = userRepository.findAll();
//		System.out.println("List of users fetched: ");
//		for (User user : users) {
//			System.out.println("User: " + user.toString());
//		}

		System.out.println("Backend up and running...");

//		List<UserItemMapping> list = userItemMappingRepository.findByItemId("item_00005");
//		List<UserItemMapping> list = userItemMappingRepository.findByUserItemCompositeId(new UserItemCompositeId("user_002", "item_00005"));
//		List<UserItemMapping> list = userItemMappingRepository.findByUserItemCompositeId(new UserItemCompositeId("", "item_00005"));

		Iterable<UserItemMapping> list = userItemMappingRepository.findByUserId("user_002", "ACTIVE");
		List<UserItemMapping> list2 = userItemMappingRepository.findByUserItemCompositeIdUserId("user_002");

		list.forEach(System.out::println);
		System.out.println("\n\n=====================================\n\n");
		list2.forEach(System.out::println);

		return list2;
	}

	@PostMapping("/getAccessToken")
	public String createItem(@RequestBody ItemCreationRequest itemCreationRequest) {
		// here we write the code to handle the item creation
		// we will get the public_token form frontend and use that to invoke the plaid
		// api
		// and get back the access_token and item_id which we will save in the db
		// a public token is for one time use and expires after 30 mins

		itemCreationRequest.setClientId(UrlConstants.CLIENT_ID);
		itemCreationRequest.setSecret(UrlConstants.SECRET);
//		itemCreationRequest.setPublicToken(publicToken);
		LOGGER.log(Level.INFO, "got request in /getAccessToken with requestBody: \n" + itemCreationRequest);
		String url = UrlConstants.BASE_URL + UrlConstants.ITEM_EXCHANGE_TOKEN;
		String requestString = itemCreationRequest.toString();

		try {
			ResponseEntity<String> response = httpClientService.postRequest(url, requestString);
			LOGGER.log(Level.INFO, "response.getBody() is: " + response.getBody());
			Gson gson = new Gson();
			LOGGER.log(Level.INFO, "printing the response caught here: " + response.getBody().toString());
			ItemCreationResponse itemCreationResponse = new ItemCreationResponse();
			itemCreationResponse = gson.fromJson(response.getBody(), ItemCreationResponse.class);
			LOGGER.log(Level.INFO, "userItemMapping: " + itemCreationResponse.toString());
			LOGGER.log(Level.INFO, "Response to be persisted: " + response);

			if (response.getStatusCode().value() >= 200 && response.getStatusCode().value() <= 299) {
				// now persist this data in DB
				UserItemMapping userItemMapping = new UserItemMapping(
						new UserItemCompositeId("user_007_1", itemCreationResponse.getItemId()), null, null, null);
				userItemMapping.setAccessToken(itemCreationResponse.getAccessToken());
				userItemMapping.setRequestId(itemCreationResponse.getRequestId());
				userItemMapping.setAccessTokenActiveStatus(GenericConstants.tokenActiveStatus.get("active"));
				userItemMappingRepository.save(userItemMapping);

			} else {
				return "Detailed error is: " + response;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@PostMapping("/accessAllItems")
	public List<FetchCreatedItemResponse> accessAllItems(@RequestBody() FetchCreatedItemRequest fetchItemRequest) {
		LOGGER.log(Level.INFO, "request received in /accessAllItems");
		List<FetchCreatedItemResponse> listOfFetchedItems= itemService.fetchAllItemsForUser(fetchItemRequest);
		LOGGER.log(Level.INFO, "returning response from /accessAllItems");
		return listOfFetchedItems;
	}
}
