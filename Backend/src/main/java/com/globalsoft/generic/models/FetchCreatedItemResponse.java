package com.globalsoft.generic.models;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Component
public class FetchCreatedItemResponse {

	@SerializedName("item")
	@Expose
	private Item item;
	@SerializedName("request_id")
	@Expose
	private String requestId;
	@SerializedName("status")
	@Expose
	private Status status;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public FetchCreatedItemResponse() {
	}

	/**
	 *
	 * @param item
	 * @param requestId
	 * @param status
	 */
	public FetchCreatedItemResponse(Item item, String requestId, Status status) {
		super();
		this.item = item;
		this.requestId = requestId;
		this.status = status;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("item", item).append("requestId", requestId).append("status", status)
				.toString();
	}

	public class Item {

		@SerializedName("available_products")
		@Expose
		private List<String> availableProducts = null;
		@SerializedName("billed_products")
		@Expose
		private List<String> billedProducts = null;
		@SerializedName("consent_expiration_time")
		@Expose
		private Object consentExpirationTime;
		@SerializedName("error")
		@Expose
		private Object error;
		@SerializedName("institution_id")
		@Expose
		private String institutionId;
		@SerializedName("institution_name")
		@Expose
		private String institutionName;		//	additionally added by me, not in the standard response by plaid.
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
		 * @param consentExpirationTime
		 * @param billedProducts
		 * @param error
		 */
		public Item(List<String> availableProducts, List<String> billedProducts, Object consentExpirationTime, Object error,
				String institutionId, String itemId, String webhook) {
			super();
			this.availableProducts = availableProducts;
			this.billedProducts = billedProducts;
			this.consentExpirationTime = consentExpirationTime;
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

		public Object getConsentExpirationTime() {
			return consentExpirationTime;
		}

		public void setConsentExpirationTime(Object consentExpirationTime) {
			this.consentExpirationTime = consentExpirationTime;
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

		public String getInstitutionName() {
			return institutionName;
		}

		public void setInstitutionName(String institutionName) {
			this.institutionName = institutionName;
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
			return "Item [availableProducts=" + availableProducts + ", billedProducts=" + billedProducts
					+ ", consentExpirationTime=" + consentExpirationTime + ", error=" + error + ", institutionId="
					+ institutionId + ", institutionName=" + institutionName + ", itemId=" + itemId + ", webhook="
					+ webhook + "]";
		}

//		@Override
//		public String toString() {
//			return new ToStringBuilder(this).append("availableProducts", availableProducts)
//					.append("billedProducts", billedProducts).append("consentExpirationTime", consentExpirationTime)
//					.append("error", error).append("institutionId", institutionId).append("itemId", itemId)
//					.append("webhook", webhook).toString();
//		}

	}

	class Status {

		@SerializedName("last_webhook")
		@Expose
		private Object lastWebhook;

		/**
		 * No args constructor for use in serialization
		 *
		 */
		public Status() {
		}

		/**
		 *
		 * @param lastWebhook
		 */
		public Status(Object lastWebhook) {
			super();
			this.lastWebhook = lastWebhook;
		}

		public Object getLastWebhook() {
			return lastWebhook;
		}

		public void setLastWebhook(Object lastWebhook) {
			this.lastWebhook = lastWebhook;
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this).append("lastWebhook", lastWebhook).toString();
		}

	}
}
