package com.sbm.shura.commonlib.dtoresponsehandler;

import java.io.Serializable;

/**
 * @author Ahmed Magdy
 */
public class ResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ResponseStatusDTO status;
	private Object data;

	public ResponseStatusDTO getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusDTO status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public ResponseDTO(){}

	public ResponseDTO(String statusCode,String statusMessageEN,String statusMessageAR, Object data) {
		super();
		this.status = new ResponseStatusDTO(statusCode,statusMessageEN,statusMessageAR,null);
		this.data = data;
	}
	
	public ResponseDTO(ResponseStatusDTO status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
	
	public ResponseDTO(String statusCode,String statusMessageEN,String statusMessageAR, String innerExceptionCode,String innerExceptionMessage) {
		super();
		this.status = new ResponseStatusDTO(statusCode, statusMessageEN, statusMessageAR, new ResponseStatusDetailsDTO(innerExceptionCode, innerExceptionMessage));
	}

	@Override
	public String toString() {
		return "ResponseDTO [status=" + status + ", data=" + data + "]";
	}
	
}


