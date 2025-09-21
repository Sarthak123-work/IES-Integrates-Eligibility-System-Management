package com.IES.DC.Service;

import javax.validation.Valid;

import com.IES.DC.Dto.EductationDto;
import com.IES.DC.Dto.IncomeDto;
import com.IES.DC.Dto.KidsDto;
import com.IES.DC.Dto.SummeryResponseDto;

public interface DcService {

	public boolean saveIncome(@Valid IncomeDto income, Integer appNum);

	public boolean saveEducation(@Valid EductationDto eduDto, Integer appNum);

	public boolean saveKids(@Valid KidsDto kidsdto, Integer appNum);

	public SummeryResponseDto getSummeryData(Integer appNum);

}
