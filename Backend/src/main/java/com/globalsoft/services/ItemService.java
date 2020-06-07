package com.globalsoft.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.globalsoft.constants.GenericConstants;
import com.globalsoft.constants.UrlConstants;
import com.globalsoft.dao.UserItemMappingRepository;
import com.globalsoft.dto.models.UserItemMapping;
import com.globalsoft.generic.models.FetchCreatedItemRequest;
import com.globalsoft.generic.models.FetchCreatedItemResponse;
import com.globalsoft.generic.models.SearchInstitutionByIdRequest;
import com.globalsoft.generic.models.SearchInstitutionByIdResponse;
import com.google.gson.Gson;

@Service
public class ItemService {

	@Autowired
	private UserItemMappingRepository userItemMappingRepository;
	@Autowired
	private GenericConstants genericConstants;
	@Autowired
	private HTTPClientService httpClientService;

	private static final Logger LOGGER = Logger.getLogger(ItemService.class.getName());

	// based on user id, fetch the access token for all the items of this user
	public List<String> getAllAccessTokenByUserId(String userId) {
		List<UserItemMapping> list = userItemMappingRepository.findByUserId(userId,
				genericConstants.tokenActiveStatus.get("activce"));
		List<String> listOfActiveAccessTokens = list.stream().map(element -> element.getAccessToken())
				.collect(Collectors.toList());
		return listOfActiveAccessTokens;
	}

	// method to access all the items with token status as active for the logged in
	// user
	public List<FetchCreatedItemResponse> fetchAllItemsForUser(FetchCreatedItemRequest fetchItemRequest) {
		// 1. based on user id, fetch the access token for all the items of this user

		// 2. loop to send out requests to plaid for all the access tokens fetched from
		// db. Write a service method for this.

		// 3. Make a list of responses for all items. fetch the institution_ids from all
		// the responses.
		// for each of the institution ids fetched in above step, write a service method
		// to call the plaid API to get the institution names, merge them in previous
		// responses, to be shown on the UI

		String userId = "user_007_1"; // later we will fetch it from the session

		// implementing step 1
		List<String> list = getAllAccessTokenByUserId(userId);
		// step 1 implementation complete
		// step 2 implementation start
		fetchItemRequest.setClientId(UrlConstants.CLIENT_ID);
		fetchItemRequest.setSecret(UrlConstants.SECRET);
		List<FetchCreatedItemResponse> listOfFetchedItems = new ArrayList<>();
		FetchCreatedItemResponse fetchedItem;
		for (String accessToken : list) {
			fetchItemRequest.setAccessToken(accessToken);
			fetchedItem = getCreatedItem(fetchItemRequest);
			listOfFetchedItems.add(fetchedItem);
		}
		// step 2 implementation ends
		// step 3 implementation starts
		for (FetchCreatedItemResponse itemFetched : listOfFetchedItems) {
			String institutionName = getInstitutionNameFromId(itemFetched.getItem().getInstitutionId());
			itemFetched.getItem().setInstitutionName(institutionName);
		}
		// step 3 implementation ends
		return listOfFetchedItems;
	}

	// To send out requests to plaid for a single access token fetched from db.
	public FetchCreatedItemResponse getCreatedItem(FetchCreatedItemRequest fetchCreatedItemRequest) {
		FetchCreatedItemResponse fetchCreatedItemResponse = new FetchCreatedItemResponse();
		try {
			String url = UrlConstants.BASE_URL + UrlConstants.GET_ITEM;
			String requestString = fetchCreatedItemRequest.toString();
			LOGGER.log(Level.INFO, "Invoking URL: " + url + ", requestString: " + requestString);
			ResponseEntity<String> response = httpClientService.postRequest(url, requestString);
			LOGGER.log(Level.INFO, "getCreatedItem -> response.getBody() is: " + response.getBody());
			Gson gson = new Gson();

			if (response.getStatusCode().value() >= 200 && response.getStatusCode().value() <= 299) {
				fetchCreatedItemResponse = gson.fromJson(response.getBody(), FetchCreatedItemResponse.class);
				LOGGER.log(Level.INFO, "fetchCreatedItemResponse: " + fetchCreatedItemResponse.toString());
			} else {
				String error = "Detailed error is: " + response;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fetchCreatedItemResponse;
	}

	// fetch the institution_name for institution_id
	public String getInstitutionNameFromId(String institutionId) {
		SearchInstitutionByIdResponse responseObj = new SearchInstitutionByIdResponse();
		String institutionName;
		try {
			String url = UrlConstants.BASE_URL + UrlConstants.GET_INSTITUTION_DETAILS_BY_ID;
			String publicKey = UrlConstants.SECRET;
			SearchInstitutionByIdRequest searchInstitutionByIdRequest = new SearchInstitutionByIdRequest(institutionId,
					publicKey);
			String requestString = searchInstitutionByIdRequest.toString();
			LOGGER.log(Level.INFO, "Invoking URL: " + url + ", requestString: " + requestString);
			ResponseEntity<String> response = httpClientService.postRequest(url, requestString);
			LOGGER.log(Level.INFO, "getInstitutionNameFromId -> response.getBody() is: " + response.getBody());
			Gson gson = new Gson();

			if (response.getStatusCode().value() >= 200 && response.getStatusCode().value() <= 299) {
				responseObj = gson.fromJson(response.getBody(), SearchInstitutionByIdResponse.class);
				LOGGER.log(Level.INFO, "SearchInstitutionByIdResponse: " + responseObj.toString());
			} else {
				String error = "Detailed error is: " + response;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseObj.getInstitution().getName();
	}
}
