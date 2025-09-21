package com.Citizen.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;


public class SsnWebRequestDTO {

	private String citizenName;

	private String citizenDOB;

	@JsonProperty("citizenSsnNumber")
	private String citizenSsnNumber;

	public String getCitizenName() {
		return citizenName;
	}     

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getCitizenDob() {
		return citizenDOB;
	}

	public void setCitizenDob(String citizenDOB) {
		this.citizenDOB = citizenDOB;
	}

	public String getCitizenSsnNo() {
		return citizenSsnNumber;
	}

	public void setCitizenSsnNo(String citizenSsnNumber) {
		this.citizenSsnNumber = citizenSsnNumber;
	}

	@Override
	public String toString() {
		return "SsnWebRequestDto [citizenName=" + citizenName + ", citizenDob=" + citizenDOB + ", citizenSsnNo="
				+ citizenSsnNumber + "]";
	}
}
