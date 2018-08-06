package com.sbm.shura.commonlib.exceptions.types;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;

/**
 * 
 * @author Ahmed Magdy
 *
 */
public class ShuraApplicationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String messageEn;
	private String messageAr;
	
	public ShuraApplicationException() {
		super();
	}
	
	public ShuraApplicationException(ExceptionEnums exEnums) {
		super(exEnums.getMessageEn());
		this.errorCode = exEnums.getCode();
		this.messageEn = exEnums.getMessageEn();
		this.messageAr = exEnums.getMessageAr();
	}
	
	
	public ShuraApplicationException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums.getMessageEn(), e);
		this.errorCode = exEnums.getCode();
		this.messageEn = exEnums.getMessageEn();
		this.messageAr = exEnums.getMessageAr();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessageEn() {
		return messageEn;
	}

	public String getMessageAr() {
		return messageAr;
	}
}
