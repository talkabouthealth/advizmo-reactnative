package com.globalsoft.generic.models;

import com.google.gson.annotations.SerializedName;

public class ItemCreationResponse {

	@SerializedName("access_token")
	private String accessToken;
	@SerializedName("item_id")
	private String itemId;
	@SerializedName("request_id")
	private String requestId;

	public ItemCreationResponse() {
		super();
	}

	public ItemCreationResponse(String accessToken, String itemId, String requestId) {
		super();
		this.accessToken = accessToken;
		this.itemId = itemId;
		this.requestId = requestId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "ItemCreationResponse [accessToken=" + accessToken + ", itemId=" + itemId + ", requestId=" + requestId
				+ "]";
	}

}
