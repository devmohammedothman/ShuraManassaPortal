package com.sbm.shura.commonlib.exceptions.types;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.ShuraApplicationException;

/**
 * 
 * @author Ahmed Magdy
 *
 */
public class BusinessException extends ShuraApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}

	public BusinessException(ExceptionEnums exEnums) {
		super(exEnums);
	}

	public BusinessException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums, e);
	}
}