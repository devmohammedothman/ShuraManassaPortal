package com.sbm.shura.commonlib.exceptions.types;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.ShuraApplicationException;

public class ControllerException extends ShuraApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ControllerException() {
		super();
	}

	public ControllerException(ExceptionEnums exEnums) {
		super(exEnums);
	}

	public ControllerException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums, e);
	}

}
