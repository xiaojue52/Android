package com.jiyuan.pmis.exception;

public class PmisException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5156819826992123511L;
	private String message;
	public PmisException(String message){
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
}
