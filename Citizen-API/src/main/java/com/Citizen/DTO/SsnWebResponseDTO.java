package com.Citizen.DTO;


public class SsnWebResponseDTO {

	private String citizenSsnNumber;

	private String stateName;

	public String getCitizenSsnNo() {
		return citizenSsnNumber;
	}

	public void setCitizenSsnNo(String citizenSsnNumber) {
		this.citizenSsnNumber = citizenSsnNumber;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "SsnWebResponseDto [citizenSsnNo=" + citizenSsnNumber + ", stateName=" + stateName + "]";
	}
}
