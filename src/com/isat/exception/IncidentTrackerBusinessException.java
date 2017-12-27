package com.isat.exception;

public class IncidentTrackerBusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2786214125662481760L;

	private String errorCode;
	private String errorMessage;

	public IncidentTrackerBusinessException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
