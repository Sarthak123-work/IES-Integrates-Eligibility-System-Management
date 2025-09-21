package com.IES.DC.Dto;

import java.util.List;

import com.IES.DC.Entity.DcEducation;
import com.IES.DC.Entity.DcIncome;
import com.IES.DC.Entity.DcKid;

import lombok.Data;

@Data
public class SummeryResponseDto {

	private List<DcEducation> educationDetails;

	private List<DcKid> kidDetails;

	private List<DcIncome> IncomdeDetails;

	public List<DcEducation> getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(List<DcEducation> educationDetails) {
		this.educationDetails = educationDetails;
	}

	public List<DcKid> getKidDetails() {
		return kidDetails;
	}

	public void setKidDetails(List<DcKid> kidDetails) {
		this.kidDetails = kidDetails;
	}

	public List<DcIncome> getIncomdeDetails() {
		return IncomdeDetails;
	}

	public void setIncomdeDetails(List<DcIncome> incomdeDetails) {
		IncomdeDetails = incomdeDetails;
	}

	@Override
	public String toString() {
		return "SummeryResponseDto [educationDetails=" + educationDetails + ", kidDetails=" + kidDetails
				+ ", IncomdeDetails=" + IncomdeDetails + "]";
	}
	
	

}
