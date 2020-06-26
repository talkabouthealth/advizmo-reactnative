package com.globalsoft.generic.models;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Component
public class SearchInstitutionByIdResponse {

	@SerializedName("institution")
	@Expose
	private Institution institution;
	@SerializedName("request_id")
	@Expose
	private String requestId;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public SearchInstitutionByIdResponse() {
	}

	/**
	 *
	 * @param institution
	 * @param requestId
	 */
	public SearchInstitutionByIdResponse(Institution institution, String requestId) {
		super();
		this.institution = institution;
		this.requestId = requestId;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("institution", institution).append("requestId", requestId).toString();
	}

	class Credential {

		@SerializedName("label")
		@Expose
		private String label;
		@SerializedName("name")
		@Expose
		private String name;
		@SerializedName("type")
		@Expose
		private String type;

		/**
		 * No args constructor for use in serialization
		 *
		 */
		public Credential() {
		}

		/**
		 *
		 * @param name
		 * @param label
		 * @param type
		 */
		public Credential(String label, String name, String type) {
			super();
			this.label = label;
			this.name = name;
			this.type = type;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this).append("label", label).append("name", name).append("type", type)
					.toString();
		}

	}

	public class Institution {

		@SerializedName("country_codes")
		@Expose
		private List<String> countryCodes = null;
		@SerializedName("credentials")
		@Expose
		private List<Credential> credentials = null;
		@SerializedName("has_mfa")
		@Expose
		private Boolean hasMfa;
		@SerializedName("oauth")
		@Expose
		private Boolean oauth;
		@SerializedName("institution_id")
		@Expose
		private String institutionId;
		@SerializedName("mfa")
		@Expose
		private List<String> mfa = null;
		@SerializedName("mfa_code_type")
		@Expose
		private String mfaCodeType;
		@SerializedName("name")
		@Expose
		private String name;
		@SerializedName("products")
		@Expose
		private List<String> products = null;
		@SerializedName("routing_numbers")
		@Expose
		private List<String> routingNumbers = null;

		/**
		 * No args constructor for use in serialization
		 *
		 */
		public Institution() {
		}

		/**
		 *
		 * @param countryCodes
		 * @param mfaCodeType
		 * @param institutionId
		 * @param credentials
		 * @param name
		 * @param mfa
		 * @param hasMfa
		 * @param products
		 * @param routingNumbers
		 */
		public Institution(List<String> countryCodes, List<Credential> credentials, Boolean hasMfa, Boolean oauth, String institutionId,
				List<String> mfa, String mfaCodeType, String name, List<String> products, List<String> routingNumbers) {
			super();
			this.countryCodes = countryCodes;
			this.credentials = credentials;
			this.hasMfa = hasMfa;
			this.oauth = oauth;
			this.institutionId = institutionId;
			this.mfa = mfa;
			this.mfaCodeType = mfaCodeType;
			this.name = name;
			this.products = products;
			this.routingNumbers = routingNumbers;
		}

		public List<String> getCountryCodes() {
			return countryCodes;
		}

		public void setCountryCodes(List<String> countryCodes) {
			this.countryCodes = countryCodes;
		}

		public List<Credential> getCredentials() {
			return credentials;
		}

		public void setCredentials(List<Credential> credentials) {
			this.credentials = credentials;
		}

		public Boolean getHasMfa() {
			return hasMfa;
		}

		public void setHasMfa(Boolean hasMfa) {
			this.hasMfa = hasMfa;
		}

		public String getInstitutionId() {
			return institutionId;
		}

		public void setInstitutionId(String institutionId) {
			this.institutionId = institutionId;
		}

		public List<String> getMfa() {
			return mfa;
		}

		public void setMfa(List<String> mfa) {
			this.mfa = mfa;
		}

		public Boolean getOauth() {
			return oauth;
		}

		public void setOauth(Boolean oauth) {
			this.oauth = oauth;
		}

		public String getMfaCodeType() {
			return mfaCodeType;
		}

		public void setMfaCodeType(String mfaCodeType) {
			this.mfaCodeType = mfaCodeType;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<String> getProducts() {
			return products;
		}

		public void setProducts(List<String> products) {
			this.products = products;
		}

		public List<String> getRoutingNumbers() {
			return routingNumbers;
		}

		public void setRoutingNumbers(List<String> routingNumbers) {
			this.routingNumbers = routingNumbers;
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this).append("countryCodes", countryCodes).append("credentials", credentials).append("hasMfa", hasMfa)
					.append("oauth", oauth).append("institutionId", institutionId).append("mfa", mfa)
					.append("mfaCodeType", mfaCodeType).append("name", name).append("products", products)
					.append("routingNumbers", routingNumbers).toString();
		}
	}
}