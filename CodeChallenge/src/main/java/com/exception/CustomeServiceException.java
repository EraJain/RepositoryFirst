package com.exception;

public class CustomeServiceException extends Exception{

	private String errMsg;
	
	public CustomeServiceException(String errMsg) {
		this.errMsg = errMsg;
	}
}
