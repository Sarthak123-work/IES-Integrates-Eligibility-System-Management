package com.IES.Exception;

public class UserAlreadyExisted extends RuntimeException {
	
	public UserAlreadyExisted(String msg) {
		super(msg);
	}

}
