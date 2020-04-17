package com.globalsoft.controllers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalsoft.constants.UrlConstants;
import com.globalsoft.dao.UserItemMappingRepository;
import com.globalsoft.dao.UserRepository;
import com.globalsoft.dto.models.Item;
import com.globalsoft.dto.models.User;
import com.globalsoft.dto.models.UserItemMapping;
import com.globalsoft.generic.models.ItemCreationRequest;
import com.globalsoft.generic.models.ItemRetrieveRequest;
import com.globalsoft.services.HTTPClientService;

@RestController
public class ItemController {
//	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserItemMappingRepository userItemMappingRepository;
	@Autowired
	HTTPClientService httpClientService;
	@Autowired
	ItemCreationRequest itemCreationRequest1;

	private static final Logger LOGGER = Logger.getLogger(ItemController.class.getName());

	@GetMapping("/check")
	public List<User> showMessage() {
		List<User> users = userRepository.findAll();
		System.out.println("List of users fetched: ");
		for (User user : users) {
			System.out.println("User: " + user.toString());
		}
		System.out.println("Backend up and running...");
		return users;
	}

	@PostMapping("/getAccessToken")
	public void createItem(@RequestBody ItemCreationRequest itemCreationRequest) {
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
			LOGGER.log(Level.INFO, "Response to be persisted: " + response);
			
//			 now persist this data in DB
			UserItemMapping userItemMapping;
//			userItemMapping = response;				// later enhance this logic for data extraction once issue resolved by plaid support
			userItemMapping = new UserItemMapping();
			userItemMappingRepository.save(userItemMapping);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//	@PostMapping("/accessItem/{userId}")
//	public Item accessItem(@PathVariable("userId") String userId) {
//
//		// based on user id, fetch the access token for all the items of this user
//		// loop to send out requests to plaid for all the access tokens fetched from db
//		String url = UrlConstants.BASE_URL + UrlConstants.GET_ITEM;
//		ItemRetrieveRequest temRetrieveRequest = new ItemRetrieveRequest();
//		return item;
//	}
}
