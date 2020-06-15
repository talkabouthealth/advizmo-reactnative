package com.globalsoft.ui.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

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

	class Summary {

		@SerializedName("available")
		@Expose
		private Integer available;
		@SerializedName("current")
		@Expose
		private Integer current;
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
		public Summary(Integer available, Integer current, String isoCurrencyCode) {
			super();
			this.available = available;
			this.current = current;
			this.isoCurrencyCode = isoCurrencyCode;
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

		@Override
		public String toString() {
			return new ToStringBuilder(this).append("available", available).append("current", current)
					.append("isoCurrencyCode", isoCurrencyCode).toString();
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

}
