package com.IES.DC.Exception;

public class ApplicationNotFoundWithThisId extends RuntimeException{

	public ApplicationNotFoundWithThisId(String msg)
	{
		super(msg);
	}
}
