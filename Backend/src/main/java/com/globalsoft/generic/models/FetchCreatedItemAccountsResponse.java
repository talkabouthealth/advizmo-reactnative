package com.globalsoft.generic.models;

import java.util.List;

import com.globalsoft.common.models.Account;
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

}
