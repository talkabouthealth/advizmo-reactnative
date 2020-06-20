package com.globalsoft.ui.models;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.globalsoft.common.models.Account;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountsSummaryResponse {

	@SerializedName("AccountTypes")
	@Expose
	private List<AccountWiseSummary> AccountTypes = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public AccountsSummaryResponse() {
	}

	/**
	 *
	 * @param AccountTypes
	 */
	public AccountsSummaryResponse(List<AccountWiseSummary> AccountTypes) {
		super();
		this.AccountTypes = AccountTypes;
	}

	public List<AccountWiseSummary> getAccountTypes() {
		return AccountTypes;
	}

	public void setAccountTypes(List<AccountWiseSummary> AccountTypes) {
		this.AccountTypes = AccountTypes;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("AccountTypes", AccountTypes).toString();
	}

	public static class AccountWiseSummary {

		@SerializedName("name")
		@Expose
		private String name;
		@SerializedName("summary")
		@Expose
		private Summary summary;
		@SerializedName("accounts")
		@Expose
		private List<Account> accounts = null;

		/**
		 * No args constructor for use in serialization
		 *
		 */
		public AccountWiseSummary() {
		}

		/**
		 *
		 * @param summary
		 * @param name
		 * @param accounts
		 */
		public AccountWiseSummary(String name, Summary summary, List<Account> accounts) {
			super();
			this.name = name;
			this.summary = summary;
			this.accounts = accounts;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Summary getSummary() {
			return summary;
		}

		public void setSummary(Summary summary) {
			this.summary = summary;
		}

		public List<Account> getAccounts() {
			return accounts;
		}

		public void setAccounts(List<Account> accounts) {
			this.accounts = accounts;
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this).append("name", name).append("summary", summary)
					.append("accounts", accounts).toString();
		}

	}

	public class Summary {

		@SerializedName("available")
		@Expose
		private Float available;
		@SerializedName("current")
		@Expose
		private Float current;
		@SerializedName("iso_currency_code")
		@Expose
		private String isoCurrencyCode;

		/**
		 * No args constructor for use in serialization
		 *
		 */
		public Summary() {
		}

		/**
		 *
		 * @param current
		 * @param available
		 * @param isoCurrencyCode
		 */
		public Summary(Float available, Float current, String isoCurrencyCode) {
			super();
			this.available = available;
			this.current = current;
			this.isoCurrencyCode = isoCurrencyCode;
		}

		public Float getAvailable() {
			return available;
		}

		public void setAvailable(Float available) {
			this.available = available;
		}

		public Float getCurrent() {
			return current;
		}

		public void setCurrent(Float current) {
			this.current = current;
		}

		public String getIsoCurrencyCode() {
			return isoCurrencyCode;
		}

		public void setIsoCurrencyCode(String isoCurrencyCode) {
			this.isoCurrencyCode = isoCurrencyCode;
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this).append("available", available).append("current", current)
					.append("isoCurrencyCode", isoCurrencyCode).toString();
		}

	}

}
