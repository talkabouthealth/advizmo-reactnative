package com.globalsoft.services;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;

import com.plaid.client.PlaidClient;
import com.plaid.client.request.ItemPublicTokenExchangeRequest;
import com.plaid.client.response.ItemPublicTokenExchangeResponse;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;

public class PlaidExample {

	private static final String PUBLIC_KEY = "public-sandbox-34f942de-2a9d-48ef-93ac-8a95f9093a5d";
	private static final String CLIENT_ID = "5e88baa97d3a1e00137c9c43";
	private static final String SECRET = "8f408f0c89bcaedc05fa69100cd379";

	static {
		HttpServer server;
		try {
			server = HttpServer.create(new InetSocketAddress("localhost", 8000), 0);
			server.createContext("/get_access_token", new GetAccessToken());
			server.setExecutor(null);
			server.start();
			System.out.println("HTTPServer initiated");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class GetAccessToken implements HttpHandler {
		private static PlaidClient plaidClient;

		private String publicToken;
		private String accessToken;
		private String itemId;

		public void handle(HttpExchange t) throws IOException {

			// Build your Plaid client
			PlaidClient plaidClient = PlaidClient.newBuilder().clientIdAndSecret(CLIENT_ID, SECRET)
					.publicKey(PUBLIC_KEY).sandboxBaseUrl().logLevel(HttpLoggingInterceptor.Level.BODY).build(); // sandbox
																													// Plaid
																													// environment

			// Exchange public_token for an access_token
			Response<ItemPublicTokenExchangeResponse> plaidResponse = plaidClient.service()
					.itemPublicTokenExchange(new ItemPublicTokenExchangeRequest(PUBLIC_KEY)).execute();

			accessToken = plaidResponse.body().getAccessToken();
			itemId = plaidResponse.body().getItemId();
			System.out.println("Fetched accessToken : " + accessToken);
			System.out.println("Fetched itemId : " + itemId);
		}
	}

}
