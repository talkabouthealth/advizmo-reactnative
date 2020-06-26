package com.globalsoft.generic.models;

import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Component
public class SearchInstitutionByIdRequest {

	@SerializedName("institution_id")
	@Expose
	private String institutionId;
	@SerializedName("public_key")
	@Expose
	private String publicKey;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public SearchInstitutionByIdRequest() {
	}

	public SearchInstitutionByIdRequest(String institutionId, String publicKey) {
		super();
		this.institutionId = institutionId;
		this.publicKey = publicKey;
	}

	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	@Override
	public String toString() {
		return "SearchInstitutionByIdRequest [institutionId=" + institutionId + ", publicKey=" + publicKey + "]";
	}
}
