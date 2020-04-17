package com.globalsoft.dto.models;

import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class UserItemCompositeId {

	public String userId;
	public String itemId;
	public UserItemCompositeId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserItemCompositeId(String userId, String itemId) {
		super();
		this.userId = userId;
		this.itemId = itemId;
	}
	
	@Override
	  public boolean equals(Object o) {
	      if (this == o) return true;
	      if (o == null || getClass() != o.getClass()) return false;
	      UserItemCompositeId taskId1 = (UserItemCompositeId) o;
	      if (userId != taskId1.userId) return false;
	      return itemId == taskId1.itemId;
	  }

	  @Override
	  public int hashCode() {
	      return Objects.hash(userId, itemId);
	  }
}
