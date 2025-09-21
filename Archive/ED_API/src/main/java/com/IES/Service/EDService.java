package com.IES.Service;

import com.IES.DTO.EdResponseDTO;

public interface EDService 
{
  EdResponseDTO determineEligibility(Integer appNumber);
  public void generatePDF();
}
