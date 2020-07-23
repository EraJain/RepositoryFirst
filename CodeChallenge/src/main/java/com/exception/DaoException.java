package com.exception;

public class DaoException extends Exception{

	private String errMsg;
	
	public DaoException(String errMsg){
		this.errMsg = errMsg;
	}
	
}
