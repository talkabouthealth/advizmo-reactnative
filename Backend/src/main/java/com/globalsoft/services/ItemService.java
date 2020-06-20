package com.globalsoft.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.globalsoft.common.models.Account;
import com.globalsoft.constants.GenericConstants;
import com.globalsoft.constants.UrlConstants;
import com.globalsoft.dao.UserItemMappingRepository;
import com.globalsoft.dto.models.UserItemMapping;
import com.globalsoft.generic.models.FetchCreatedItemAccountsResponse;
import com.globalsoft.generic.models.FetchCreatedItemAccountsSummaryRequest;
import com.globalsoft.generic.models.FetchCreatedItemRequest;
import com.globalsoft.generic.models.FetchCreatedItemResponse;
import com.globalsoft.generic.models.SearchInstitutionByIdRequest;
import com.globalsoft.generic.models.SearchInstitutionByIdResponse;
import com.globalsoft.ui.models.AccountsSummaryResponse;
import com.globalsoft.ui.models.AccountsSummaryResponse.AccountWiseSummary;
import com.google.gson.Gson;

@Service
public class ItemService {

	@Autowired
	private UserItemMappingRepository userItemMappingRepository;
//	@Autowired
//	private GenericConstants genericConstants;
	@Autowired
	private HTTPClientService httpClientService;

	private static final Logger LOGGER = Logger.getLogger(ItemService.class.getName());

	// based on user id, fetch the access token for all the items of this user
	public List<String> getAllAccessTokenByUserId(String userId) {
		LOGGER.log(Level.INFO, "sending userId as: " + userId);
		LOGGER.log(Level.INFO, "sending tokenActiveStatus as: " + GenericConstants.tokenActiveStatus.get("active"));
		List<UserItemMapping> list = userItemMappingRepository.findByUserId(userId,
				GenericConstants.tokenActiveStatus.get("active"));
		LOGGER.log(Level.INFO, "list size of access tokens fetched: " + list.size());
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

		// this will basically show the list of banks with whom the client has an
		// account and has created item on our app via plaid
		return listOfFetchedItems;
	}

	// Method to fetch all the accounts of a user and return the summary grouped by
	// account types
	public AccountsSummaryResponse fetchAllAccountsSummaryForUser() {
		// 1. based on user id, fetch the access token for all the items of this user

		// 2. loop to send out requests to plaid for all the access tokens fetched from
		// db. Write a service method for this.

		// 3. traverse all the accounts and aggregate them in a map based on their
		// account types
		// 4. then finally make the UI response object
		FetchCreatedItemAccountsSummaryRequest fetchAccountsRequest = new FetchCreatedItemAccountsSummaryRequest();
		String userId = "user_007_1"; // later we will fetch it from the session

		// implementing step 1
		List<String> list = getAllAccessTokenByUserId(userId);
		// step 1 implementation complete
		// step 2 implementation start
		fetchAccountsRequest.setClientId(UrlConstants.CLIENT_ID);
		fetchAccountsRequest.setSecret(UrlConstants.SECRET);
		List<FetchCreatedItemAccountsResponse> listOfFetchedAccounts = new ArrayList<>();
		FetchCreatedItemAccountsResponse fetchedAccountsForItem = new FetchCreatedItemAccountsResponse();
		for (String accessToken : list) {
			LOGGER.log(Level.INFO, "accessToken fetched for this user: " + accessToken);
			fetchAccountsRequest.setAccessToken(accessToken);

			fetchedAccountsForItem = getAccountsForCreatedItem(fetchAccountsRequest); // to be implemented

			listOfFetchedAccounts.add(fetchedAccountsForItem);
		}
		// step 2 implementation ends
		// step 3 implementation starts
		Map<String, AccountWiseSummary> finalMap = new HashMap<>();
		LOGGER.log(Level.INFO, "listOfFetchedAccounts size is: " + listOfFetchedAccounts.size());
		for (FetchCreatedItemAccountsResponse fetchedAccountsPerItem : listOfFetchedAccounts) {
			for (int i = 0; i < fetchedAccountsPerItem.getAccounts().size(); i++) {
				Account account = fetchedAccountsPerItem.getAccounts().get(i);
				String accountType = account.getType();
				if (finalMap.containsKey(accountType)) {
					LOGGER.log(Level.INFO, "inside if of final map");
					AccountWiseSummary accountWiseSummary = finalMap.get(accountType);
					List<Account> accounts = Collections.singletonList(account);
					LOGGER.log(Level.INFO,
							"accountWiseSummary.getAccounts() size: " + accountWiseSummary.getAccounts().size());
					accountWiseSummary.setName(accountType);
					AccountsSummaryResponse.Summary summary = new AccountsSummaryResponse().new Summary(0.0F, 0.0F, "");
					Float existingAvailableAmount = accountWiseSummary.getSummary().getAvailable();
					Float existingCurrentAmount = accountWiseSummary.getSummary().getCurrent();
					LOGGER.log(Level.INFO, "existingAvailableAmount: " + existingAvailableAmount);
					LOGGER.log(Level.INFO, "existingCurrentAmount: " + existingCurrentAmount);

					if (existingAvailableAmount != null && account.getBalances().getAvailable() != null) {
						summary.setAvailable(existingAvailableAmount + account.getBalances().getAvailable());
						LOGGER.log(Level.INFO, "new existingAvailableAmount after addition "
								+ account.getBalances().getAvailable() + ": " + summary.getAvailable());
					} else {
						summary.setAvailable(existingAvailableAmount);
					}
					if (existingCurrentAmount != null && account.getBalances().getCurrent() != null) {
						summary.setCurrent(existingCurrentAmount + account.getBalances().getCurrent());
						LOGGER.log(Level.INFO, "new existingCurrentAmount after addition "
								+ account.getBalances().getCurrent() + ": " + summary.getCurrent());
					} else {
						summary.setCurrent(existingCurrentAmount);
					}
					summary.setIsoCurrencyCode(account.getBalances().getIsoCurrencyCode());
					accountWiseSummary.setSummary(summary);
					LOGGER.log(Level.INFO,
							"accountWiseSummary.getAccounts() size: " + accountWiseSummary.getAccounts().size());
					LOGGER.log(Level.INFO, "accounts: " + accounts);
					accountWiseSummary.getAccounts().addAll(accounts);
					finalMap.put(accountType, accountWiseSummary);
				} else {
					LOGGER.log(Level.INFO, "inside else of final map");
					AccountWiseSummary accountWiseSummary = new AccountWiseSummary();
					List<Account> accounts = new ArrayList<>();
					accounts.add(account);
					accountWiseSummary.setName(accountType);
					AccountsSummaryResponse.Summary summary = new AccountsSummaryResponse().new Summary(0.0F, 0.0F, "");
					if (account.getBalances().getAvailable() != null) {
						summary.setAvailable(account.getBalances().getAvailable());
					}
					if (account.getBalances().getCurrent() != null) {
						summary.setCurrent(account.getBalances().getCurrent());
					}
					if (account.getBalances().getIsoCurrencyCode() != null
							&& account.getBalances().getIsoCurrencyCode().trim() != "") {
						summary.setIsoCurrencyCode(account.getBalances().getIsoCurrencyCode());
					}
					accountWiseSummary.setSummary(summary);
					accountWiseSummary.setAccounts(accounts);
					finalMap.put(accountType, accountWiseSummary);
				}
			}
		}
		// step 3 implementation ends
		// step 4 implementation starts
		AccountsSummaryResponse accountsSummaryResponse = new AccountsSummaryResponse(new ArrayList<>());
		Set<String> keys = finalMap.keySet();
		for (String key : keys) {
			accountsSummaryResponse.getAccountTypes().addAll(Arrays.asList(finalMap.get(key)));
		}
		// step 4 implementation ends
		// this will basically show the list of summary of accounts seggregated based on
		// the account type
		return accountsSummaryResponse;
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

	public FetchCreatedItemAccountsResponse getAccountsForCreatedItem(
			FetchCreatedItemAccountsSummaryRequest fetchAccountsRequest) {
		LOGGER.log(Level.INFO, "Sending request to plaid for this access token");
		String url = UrlConstants.BASE_URL + UrlConstants.GET_AL_ACCOUNTS_UNDER_EACH_ITEM;
		LOGGER.log(Level.INFO, "invoking url: " + url);
		LOGGER.log(Level.INFO, "sending RequestBody: " + fetchAccountsRequest);
		ResponseEntity<String> response;
		try {
			response = httpClientService.postRequest(url, fetchAccountsRequest.toString());
//			LOGGER.log(Level.INFO, "getAccountsForCreatedItem -> response.getBody() is: " + response.getBody());
			Gson gson = new Gson();
			FetchCreatedItemAccountsResponse itemsAccountsSummaryResponse = gson.fromJson(response.getBody(),
					FetchCreatedItemAccountsResponse.class);
			LOGGER.log(Level.INFO, "Response fetched is:" + itemsAccountsSummaryResponse);
			return itemsAccountsSummaryResponse;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.log(Level.SEVERE, "returning null, as some exception occurred above");
		return null;
	}

//	public void cloneAccount(AccountsSummaryResponse.Account toBeSetAccount, FetchCreatedItemAccountsResponse.Account fetchedAccount) {
//		toBeSetAccount.setAccountId(fetchedAccount.getAccountId());
//		toBeSetAccount.setBalances(fetchedAccount.getBalances());
//		toBeSetAccount.setAccountId(fetchedAccount.getMask());
//		toBeSetAccount.setAccountId(fetchedAccount.getName());
//		toBeSetAccount.setAccountId(fetchedAccount.getOfficialName());
//		toBeSetAccount.setAccountId(fetchedAccount.getSubtype());
//		toBeSetAccount.setAccountId(fetchedAccount.getType());
//	}
}
