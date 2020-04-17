package com.globalsoft.dto.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_item_mapping")
public class UserItemMapping {

	@EmbeddedId              
	public UserItemCompositeId userItemCompositeId;
	@Column(name = "access_token")
	public String accessToken;              
	@Column(name = "request_id")
	public String requestId;            
	@Column(name = "access_token_active_status")
	public String accessTokenActiveStatus;
	
	public UserItemMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserItemMapping(UserItemCompositeId userItemCompositeId, String accessToken, String requestId,
			String accessTokenActiveStatus) {
		super();
		this.userItemCompositeId = userItemCompositeId;
		this.accessToken = accessToken;
		this.requestId = requestId;
		this.accessTokenActiveStatus = accessTokenActiveStatus;
	}

	public UserItemCompositeId getUserId() {
		return userItemCompositeId;
	}

	public void setUserId(UserItemCompositeId userItemCompositeId) {
		this.userItemCompositeId = userItemCompositeId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getAccessTokenActiveStatus() {
		return accessTokenActiveStatus;
	}

	public void setAccessTokenActiveStatus(String accessTokenActiveStatus) {
		this.accessTokenActiveStatus = accessTokenActiveStatus;
	}

	@Override
	public String toString() {
		return "UserItemMapping [UserItemCompositeId=" + userItemCompositeId + ", accessToken=" + accessToken
				+ ", requestId=" + requestId + ", accessTokenActiveStatus=" + accessTokenActiveStatus + "]";
	}

}
