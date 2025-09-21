package com.DTO;

public class SsnWebRequestDTO {
	
	private String citizenName;
	
	private String citizenDOB;
	
	private String citizenSsnNumber;

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getCitizenDOB() {
		return citizenDOB;
	}

	public void setCitizenDOB(String citizenDOB) {
		this.citizenDOB = citizenDOB;
	}

	public String getCitizenSsnNumber() {
		return citizenSsnNumber;
	}

	public void setCitizenSsnNumber(String citizenSsnNumber) {
		this.citizenSsnNumber = citizenSsnNumber;
	}

	@Override
	public String toString() {
		return "SsnWebRequestDTO [citizenName=" + citizenName + ", citizenDOB=" + citizenDOB + ", citizenSsnNumber="
				+ citizenSsnNumber + "]";
	}
	
	

}
