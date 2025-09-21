package com.DTO;

public class SSnWebResponseDTO {
	
	private String citizenSsnNumber;
	
	private String stateName;

	public String getCitizenSsnNumber() {
		return citizenSsnNumber;
	}

	public void setCitizenSsnNumber(String citizenSsnNumber) {
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
		return "SSnWebResponseDTO [citizenSsnNumber=" + citizenSsnNumber + ", stateName=" + stateName + "]";
	}
	
	

}
