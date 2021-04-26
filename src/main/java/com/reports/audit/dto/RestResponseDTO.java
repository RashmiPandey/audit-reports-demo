package com.reports.audit.dto;

/**
 * 
 * @author rashmi
 * @version 1.0
 * 
 * Common response data transfer object
 *
 */
public class RestResponseDTO {

	private String status;
	private String message;
	private Object data;

	public RestResponseDTO(String status) {
		this(status, null);
	}

	public RestResponseDTO(String status, String message) {
		this(status, message, null);
	}

	public RestResponseDTO(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		if (status == null) {
			status = "";
		}
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		if (message == null) {
			message = "";
		}
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RestResponseDTO [status=" + getStatus() + ", message=" + getMessage() + ", data=" + getData() + "]";
	}
}
