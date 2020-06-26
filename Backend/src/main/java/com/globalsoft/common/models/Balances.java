package com.globalsoft.common.models;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Balances {

	@SerializedName("available")
	@Expose
	private Float available;
	@SerializedName("current")
	@Expose
	private Float current;
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
	public Balances(Float available, Float current, String isoCurrencyCode, Object limit,
			Object unofficialCurrencyCode) {
		super();
		this.available = available;
		this.current = current;
		this.isoCurrencyCode = isoCurrencyCode;
		this.limit = limit;
		this.unofficialCurrencyCode = unofficialCurrencyCode;
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