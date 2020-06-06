package com.globalsoft.dto.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "user_item_mapping")
public class UserItemMapping implements Serializable{

	@EmbeddedId              
	public UserItemCompositeId userItemCompositeId;
	@Column(name = "access_token")
	@SerializedName("access_token")
	public String accessToken;              
	@Column(name = "request_id")
	@SerializedName("request_id")
	public String requestId;            
	@Column(name = "access_token_active_status")
	public String accessTokenActiveStatus;
	
	public UserItemMapping() {
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

	public UserItemCompositeId getUserItemCompositeId() {
		return userItemCompositeId;
	}

	public void setUserItemCompositeId(UserItemCompositeId userItemCompositeId) {
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
	  public boolean equals(Object o) {
	      if (this == o) return true;
	      if (o == null || getClass() != o.getClass()) return false;
	      UserItemMapping thatObj = (UserItemMapping) o;
	      
	      return userItemCompositeId.equals(thatObj.userItemCompositeId) &&
	    		  accessToken.equals(thatObj.accessToken) &&
	    		  requestId.equals(thatObj.requestId) &&
	    		  accessTokenActiveStatus.equals(thatObj.accessTokenActiveStatus);
	  }

	@Override
	public String toString() {
		return "UserItemMapping [userId=" + userItemCompositeId.getUserId() + ", itemId=" + userItemCompositeId.getItemId() + ", accessToken=" + accessToken
				+ ", requestId=" + requestId + ", accessTokenActiveStatus=" + accessTokenActiveStatus + "]";
	}

}
