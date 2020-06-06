package com.globalsoft.dto.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	public String id;
	public String name;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + "]";
	}
	
}
