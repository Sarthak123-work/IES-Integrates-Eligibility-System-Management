package com.IES.Security;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomerUserDetails extends UserDetails{
	
	String getEmail();

}
