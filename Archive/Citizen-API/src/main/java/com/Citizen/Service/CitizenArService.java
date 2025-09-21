package com.Citizen.Service;

import java.util.List;

import com.Citizen.DTO.CitizenDTO;
import com.Citizen.Entity.CitizenApplication;

public interface CitizenArService {
	
	public boolean createApplication(CitizenDTO citizenDto);

	public CitizenApplication getApp(Integer appNum);

	public List<CitizenApplication> getApps();

	public CitizenApplication getAppWithCitizenId(Integer citizenId);

}
