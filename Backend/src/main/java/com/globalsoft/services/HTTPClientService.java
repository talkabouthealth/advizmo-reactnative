package com.globalsoft.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HTTPClientService {

	private static final Logger LOGGER = Logger.getLogger(HTTPClientService.class.getName());

	public ResponseEntity<String> postRequest(String url, String requestBody)
			throws ClientProtocolException, IOException {
		LOGGER.log(Level.INFO, "Invoking URL: " + url);
		LOGGER.log(Level.INFO, "Sending RequestBody: \n" + requestBody);

		CloseableHttpClient client = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(url);
		StringEntity entity = new StringEntity(requestBody);
		httpPost.setEntity(entity);
		
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);
		StatusLine statusLine = response.getStatusLine();
		ResponseEntity<String> responseEntity;
		if (statusLine.getStatusCode() == 200) {
			LOGGER.log(Level.INFO, statusLine.getStatusCode() + " " + statusLine.getReasonPhrase());
	        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
	        System.out.println("Response body: " + responseBody);
	        responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
		} else {
			LOGGER.log(Level.INFO, statusLine.getStatusCode() + " " + statusLine.getReasonPhrase());
	        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
	        System.out.println("Response body: " + responseBody);
	        responseEntity = new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);		// later make it more meaningful
		}
		client.close();

		return responseEntity;
	}

	public void exchangePublicToken() {
		
	}
}
