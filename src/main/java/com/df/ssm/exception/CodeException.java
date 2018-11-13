package com.df.ssm.exception;

import com.alibaba.fastjson.annotation.JSONField;

public class CodeException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 337735578408072518L;

	
	private int code;
	
	private String message;

	public CodeException(int code) {
		super("code."+code);
		this.code = code;
	}



	public CodeException(int code, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super("code."+code, cause, enableSuppression, writableStackTrace);
		this.code = code;
	}




	public CodeException(int code, Throwable cause) {
		super("code."+code,cause);
		this.code = code;
	}






	public int getCode() {
		return code;
	}



	public String getMessage() {
		return message==null?super.getMessage():message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	@JSONField(serialize=false)
	@Override
	public String getLocalizedMessage() {
		return super.getLocalizedMessage();
	}


	@JSONField(serialize=false)
	@Override
	public synchronized Throwable getCause() {
		return super.getCause();
	}


	@JSONField(serialize=false)
	@Override
	public StackTraceElement[] getStackTrace() {
		return super.getStackTrace();
	}
	
	
	
	
	public boolean getOk(){
		return false;
	}
	
	
	
	

}
