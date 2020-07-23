package com.exceptions;

public class DAOException extends Exception{
	
	private String errMsg;
	
	public DAOException(String errMsg) {
		this.errMsg = errMsg;
	}

}
