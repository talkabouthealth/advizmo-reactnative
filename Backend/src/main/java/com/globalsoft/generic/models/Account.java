package com.globalsoft.generic.models;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {

	@SerializedName("account_id")
	@Expose
	private String accountId;
	@SerializedName("balances")
	@Expose
	private Balances balances;
	@SerializedName("mask")
	@Expose
	private String mask;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("subtype")
	@Expose
	private String subtype;
	@SerializedName("type")
	@Expose
	private String type;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Account() {
	}

	/**
	 *
	 * @param accountId
	 * @param balances
	 * @param subtype
	 * @param name
	 * @param type
	 * @param mask
	 */
	public Account(String accountId, Balances balances, String mask, String name, String subtype, String type) {
		super();
		this.accountId = accountId;
		this.balances = balances;
		this.mask = mask;
		this.name = name;
		this.subtype = subtype;
		this.type = type;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Balances getBalances() {
		return balances;
	}

	public void setBalances(Balances balances) {
		this.balances = balances;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("accountId", accountId).append("balances", balances)
				.append("mask", mask).append("name", name).append("subtype", subtype).append("type", type).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(accountId).append(balances).append(subtype).append(name).append(type)
				.append(mask).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Account) == false) {
			return false;
		}
		Account rhs = ((Account) other);
		return new EqualsBuilder().append(accountId, rhs.accountId).append(balances, rhs.balances)
				.append(subtype, rhs.subtype).append(name, rhs.name).append(type, rhs.type).append(mask, rhs.mask)
				.isEquals();
	}

}

class Balances {

	@SerializedName("available")
	@Expose
	private Object available;
	@SerializedName("currency")
	@Expose
	private String currency;
	@SerializedName("current")
	@Expose
	private Integer current;
	@SerializedName("localized")
	@Expose
	private Localized localized;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Balances() {
	}

	/**
	 *
	 * @param current
	 * @param available
	 * @param localized
	 * @param currency
	 */
	public Balances(Object available, String currency, Integer current, Localized localized) {
		super();
		this.available = available;
		this.currency = currency;
		this.current = current;
		this.localized = localized;
	}

	public Object getAvailable() {
		return available;
	}

	public void setAvailable(Object available) {
		this.available = available;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Localized getLocalized() {
		return localized;
	}

	public void setLocalized(Localized localized) {
		this.localized = localized;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("available", available).append("currency", currency)
				.append("current", current).append("localized", localized).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(available).append(localized).append(currency).append(current).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Balances) == false) {
			return false;
		}
		Balances rhs = ((Balances) other);
		return new EqualsBuilder().append(available, rhs.available).append(localized, rhs.localized)
				.append(currency, rhs.currency).append(current, rhs.current).isEquals();
	}

}

class Item {

	@SerializedName("accounts")
	@Expose
	private List<Account> accounts = null;
	@SerializedName("public_token")
	@Expose
	private String publicToken;
	@SerializedName("request_id")
	@Expose
	private String requestId;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Item() {
	}

	/**
	 *
	 * @param publicToken
	 * @param requestId
	 * @param accounts
	 */
	public Item(List<Account> accounts, String publicToken, String requestId) {
		super();
		this.accounts = accounts;
		this.publicToken = publicToken;
		this.requestId = requestId;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getPublicToken() {
		return publicToken;
	}

	public void setPublicToken(String publicToken) {
		this.publicToken = publicToken;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("accounts", accounts).append("publicToken", publicToken)
				.append("requestId", requestId).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(publicToken).append(accounts).append(requestId).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Item) == false) {
			return false;
		}
		Item rhs = ((Item) other);
		return new EqualsBuilder().append(publicToken, rhs.publicToken).append(accounts, rhs.accounts)
				.append(requestId, rhs.requestId).isEquals();
	}

}

class Localized {

	@SerializedName("available")
	@Expose
	private Object available;
	@SerializedName("current")
	@Expose
	private String current;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Localized() {
	}

	/**
	 *
	 * @param current
	 * @param available
	 */
	public Localized(Object available, String current) {
		super();
		this.available = available;
		this.current = current;
	}

	public Object getAvailable() {
		return available;
	}

	public void setAvailable(Object available) {
		this.available = available;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("available", available).append("current", current).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(available).append(current).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Localized) == false) {
			return false;
		}
		Localized rhs = ((Localized) other);
		return new EqualsBuilder().append(available, rhs.available).append(current, rhs.current).isEquals();
	}

}