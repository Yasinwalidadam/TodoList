package com.backend.PageAccueil.Bean;

public class MessageTransmis {
	private String message;

	public MessageTransmis(String message) {
		this.message=message;
	}

	@Override
	public String toString() {
		return "AutenticationBean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
