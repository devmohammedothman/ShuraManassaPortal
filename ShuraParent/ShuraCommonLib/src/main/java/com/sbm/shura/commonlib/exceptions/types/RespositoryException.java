package com.sbm.shura.commonlib.exceptions.types;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.ShuraApplicationException;

public class RespositoryException extends ShuraApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RespositoryException() {
		super();
	}

	public RespositoryException(ExceptionEnums exEnums) {
		super(exEnums);
	}

	public RespositoryException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums, e);
	}
}
