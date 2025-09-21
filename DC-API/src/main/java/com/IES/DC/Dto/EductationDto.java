package com.IES.DC.Dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EductationDto {

	@NotBlank
	@Column(name = "highest_degree", nullable = false)
	private String highestDegree;

	@NotNull
	@Column(name = "grad_year", nullable = false)
	private Integer gradYear;

	@NotBlank
	@Column(name = "uni_name", nullable = false)
	private String uniName;

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public Integer getGradYear() {
		return gradYear;
	}

	public void setGradYear(Integer gradYear) {
		this.gradYear = gradYear;
	}

	public String getUniName() {
		return uniName;
	}

	public void setUniName(String uniName) {
		this.uniName = uniName;
	}

	@Override
	public String toString() {
		return "EductationDto [highestDegree=" + highestDegree + ", gradYear=" + gradYear + ", uniName=" + uniName
				+ "]";
	}
	
	
	
}
