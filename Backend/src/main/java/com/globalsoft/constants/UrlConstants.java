package com.globalsoft.constants;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class UrlConstants {

	public static final String CLIENT_ID = "5e88baa97d3a1e00137c9c43";
	public static final String SECRET = "8f408f0c89bcaedc05fa69100cd379";
	public static final String BASE_URL = "https://sandbox.plaid.com";
	public static final String ITEM_EXCHANGE_TOKEN = "/item/public_token/exchange";
	public static final String GET_ITEM = "/item/get";
	public static final String GET_INSTITUTION_DETAILS_BY_ID = "/institutions/get_by_id";
	public static final String GET_AL_ACCOUNTS_UNDER_EACH_ITEM = "/accounts/get";
	
//	public static final String BASE_URL = "https://sandbox.plaid.com/";
//	public static final String BASE_URL = "https://sandbox.plaid.com/";
//	public static final String BASE_URL = "https://sandbox.plaid.com/";
//	public static final String BASE_URL = "https://sandbox.plaid.com/";
	
}
