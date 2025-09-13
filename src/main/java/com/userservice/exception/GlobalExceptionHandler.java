package com.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userservice.payload.ApiResponse;

//pure project mein kahi bhi exception aati hai yaah par handle kar sakte hai
@RestControllerAdvice 
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourcesNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourcesNotFoundException(ResourcesNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		// builder() iska yeaah hii fyaada kaunse bhi class object build kar sakte buss wohh class ke upar @builder laga do
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
	
}
