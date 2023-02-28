package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class EntityNotFoundException extends RuntimeException {
	public EntityNotFoundException(String msg) {
		super(msg);
	}
}
