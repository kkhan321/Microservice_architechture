package com.userservice.exception;

public class ResourcesNotFoundException extends RuntimeException {

	public ResourcesNotFoundException() {
		super("Resources not found excetion");
	}
	
	public ResourcesNotFoundException(String message) {
		super(message);
	} 
}
