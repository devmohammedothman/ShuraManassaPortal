package com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums;

import com.sbm.shura.commonlib.utilities.MessagesUtil;

public enum ExceptionEnums {
	
	INVALID_REQUEST("Shura.controller.code.1000"),
	INVALID_OPERATION("Shura.controller.code.1003"),
	
	BUSINESS_ERROR("Shura.business.code.3000"),
	
	REPOSITORY_ERROR("Shura.repository.code.4000");
	
	private String code;
	private String messageEn;
	private String messageAr;
	
	ExceptionEnums(String code){
		this.code = code;
		this.messageEn = MessagesUtil.getMessageEn(code);
		this.messageAr = MessagesUtil.getMessageAr(code);
	}

	public String getCode() {
		return code;
	}

	public String getMessageEn() {
		return messageEn;
	}

	public String getMessageAr() {
		return messageAr;
	}
}
