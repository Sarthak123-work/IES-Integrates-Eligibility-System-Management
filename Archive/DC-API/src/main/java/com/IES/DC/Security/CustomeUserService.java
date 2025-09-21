package com.IES.DC.Security;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomeUserService extends UserDetails {
	String getEmail();
}
