package com.exception;

public class NoCustomerFound extends Exception{
	
	private String errMsg;
	
	public NoCustomerFound(String errMsg) {
		this.errMsg = errMsg;
	}

}
