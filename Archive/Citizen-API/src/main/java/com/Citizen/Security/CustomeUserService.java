package com.Citizen.Security;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomeUserService extends UserDetails {
	String getEmail();
}
