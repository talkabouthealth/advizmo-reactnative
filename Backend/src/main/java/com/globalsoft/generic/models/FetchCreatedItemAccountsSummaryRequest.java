package com.globalsoft.generic.models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class FetchCreatedItemAccountsSummaryRequest {

	@JsonProperty("client_id")
	private String clientId;
	@JsonProperty("secret")
	private String secret;
	@JsonProperty("access_token")
	private String accessToken;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public FetchCreatedItemAccountsSummaryRequest() {
	}

	public FetchCreatedItemAccountsSummaryRequest(String clientId, String secret, String accessToken) {
		super();
		this.clientId = clientId;
		this.secret = secret;
		this.accessToken = accessToken;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public String toString() {
		return "{\"client_id\":\"" + clientId + "\",\"secret\":\"" + secret + "\",\"access_token\":\"" + accessToken
				+ "\"}";
	}
	
}