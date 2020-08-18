package com.backend.PageAccueil.Bean;

public class AcceueilBean {

	private String message;

	public AcceueilBean(String message) {
		this.message=message;
	}

	@Override
	public String toString() {
		return "HelloBean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
