package com.globalsoft.dto.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.gson.annotations.SerializedName;

@Embeddable
public class UserItemCompositeId implements Serializable {

	@Column(name = "user_id")
	public String userId;
	@Column(name = "item_id")
	public String itemId;
	public UserItemCompositeId() {
		// TODO Auto-generated constructor stub
	}
	public UserItemCompositeId(String userId, String itemId) {
		this.userId = userId;
		this.itemId = itemId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	@Override
	  public boolean equals(Object o) {
	      if (this == o) return true;
	      if (o == null || getClass() != o.getClass()) return false;
	      UserItemCompositeId taskId1 = (UserItemCompositeId) o;
	      
	      return userId.equals(taskId1.userId) &&
	    		  itemId.equals(taskId1.itemId);
	  }

	  @Override
	  public int hashCode() {
	      return Objects.hash(userId, itemId);
	  }
}