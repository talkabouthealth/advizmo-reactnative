package com.globalsoft.generic.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FetchCreatedItemAccountsResponse {

	@SerializedName("accounts")
	@Expose
	private List<Account> accounts = null;
	@SerializedName("item")
	@Expose
	private Item item;
	@SerializedName("request_id")
	@Expose
	private String requestId;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public FetchCreatedItemAccountsResponse() {
	}

	/**
	 *
	 * @param item
	 * @param requestId
	 * @param accounts
	 */
	public FetchCreatedItemAccountsResponse(List<Account> accounts, Item item, String requestId) {
		super();
		this.accounts = accounts;
		this.item = item;
		this.requestId = requestId;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("accounts", accounts).append("item", item)
				.append("requestId", requestId).toString();
	}

	class Item {

		@SerializedName("available_products")
		@Expose
		private List<String> availableProducts = null;
		@SerializedName("billed_products")
		@Expose
		private List<String> billedProducts = null;
		@SerializedName("error")
		@Expose
		private Object error;
		@SerializedName("institution_id")
		@Expose
		private String institutionId;
		@SerializedName("item_id")
		@Expose
		private String itemId;
		@SerializedName("webhook")
		@Expose
		private String webhook;

		/**
		 * No args constructor for use in serialization
		 *
		 */
		public Item() {
		}

		/**
		 *
		 * @param itemId
		 * @param webhook
		 * @param institutionId
		 * @param availableProducts
		 * @param billedProducts
		 * @param error
		 */
		public Item(List<String> availableProducts, List<String> billedProducts, Object error, String institutionId,
				String itemId, String webhook) {
			super();
			this.availableProducts = availableProducts;
			this.billedProducts = billedProducts;
			this.error = error;
			this.institutionId = institutionId;
			this.itemId = itemId;
			this.webhook = webhook;
		}

		public List<String> getAvailableProducts() {
			return availableProducts;
		}

		public void setAvailableProducts(List<String> availableProducts) {
			this.availableProducts = availableProducts;
		}

		public List<String> getBilledProducts() {
			return billedProducts;
		}

		public void setBilledProducts(List<String> billedProducts) {
			this.billedProducts = billedProducts;
		}

		public Object getError() {
			return error;
		}

		public void setError(Object error) {
			this.error = error;
		}

		public String getInstitutionId() {
			return institutionId;
		}

		public void setInstitutionId(String institutionId) {
			this.institutionId = institutionId;
		}

		public String getItemId() {
			return itemId;
		}

		public void setItemId(String itemId) {
			this.itemId = itemId;
		}

		public String getWebhook() {
			return webhook;
		}

		public void setWebhook(String webhook) {
			this.webhook = webhook;
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this).append("availableProducts", availableProducts)
					.append("billedProducts", billedProducts).append("error", error)
					.append("institutionId", institutionId).append("itemId", itemId).append("webhook", webhook)
					.toString();
		}

	}

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
		@SerializedName("official_name")
		@Expose
		private String officialName;
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
		 * @param officialName
		 * @param type
		 * @param mask
		 */
		public Account(String accountId, Balances balances, String mask, String name, String officialName,
				String subtype, String type) {
			super();
			this.accountId = accountId;
			this.balances = balances;
			this.mask = mask;
			this.name = name;
			this.officialName = officialName;
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

		public String getOfficialName() {
			return officialName;
		}

		public void setOfficialName(String officialName) {
			this.officialName = officialName;
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
					.append("mask", mask).append("name", name).append("officialName", officialName)
					.append("subtype", subtype).append("type", type).toString();
		}

	}

	class Balances {

		@SerializedName("available")
		@Expose
		private Integer available;
		@SerializedName("current")
		@Expose
		private Integer current;
		@SerializedName("iso_currency_code")
		@Expose
		private String isoCurrencyCode;
		@SerializedName("limit")
		@Expose
		private Object limit;
		@SerializedName("unofficial_currency_code")
		@Expose
		private Object unofficialCurrencyCode;

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
		 * @param limit
		 * @param unofficialCurrencyCode
		 * @param isoCurrencyCode
		 */
		public Balances(Integer available, Integer current, String isoCurrencyCode, Object limit,
				Object unofficialCurrencyCode) {
			super();
			this.available = available;
			this.current = current;
			this.isoCurrencyCode = isoCurrencyCode;
			this.limit = limit;
			this.unofficialCurrencyCode = unofficialCurrencyCode;
		}

		public Integer getAvailable() {
			return available;
		}

		public void setAvailable(Integer available) {
			this.available = available;
		}

		public Integer getCurrent() {
			return current;
		}

		public void setCurrent(Integer current) {
			this.current = current;
		}

		public String getIsoCurrencyCode() {
			return isoCurrencyCode;
		}

		public void setIsoCurrencyCode(String isoCurrencyCode) {
			this.isoCurrencyCode = isoCurrencyCode;
		}

		public Object getLimit() {
			return limit;
		}

		public void setLimit(Object limit) {
			this.limit = limit;
		}

		public Object getUnofficialCurrencyCode() {
			return unofficialCurrencyCode;
		}

		public void setUnofficialCurrencyCode(Object unofficialCurrencyCode) {
			this.unofficialCurrencyCode = unofficialCurrencyCode;
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this).append("available", available).append("current", current)
					.append("isoCurrencyCode", isoCurrencyCode).append("limit", limit)
					.append("unofficialCurrencyCode", unofficialCurrencyCode).toString();
		}

	}

}
