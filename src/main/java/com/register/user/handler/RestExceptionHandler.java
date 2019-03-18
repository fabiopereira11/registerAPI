package com.register.user.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.register.user.error.ResourceEmailAlreadyRegisteredDetails;
import com.register.user.error.ResourceEmailAlreadyRegisteredException;
import com.register.user.error.ValidationErrorDetails;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(ResourceEmailAlreadyRegisteredException.class)
	public ResponseEntity<?> handlerResourceEmailAlreadyRegisteredException(ResourceEmailAlreadyRegisteredException rearException){
		ResourceEmailAlreadyRegisteredDetails buildDetails = ResourceEmailAlreadyRegisteredDetails.builder().message(rearException.getMessage()).build();
		
		return new ResponseEntity<>(buildDetails,HttpStatus.CONFLICT); 
		
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException manvException){
		ValidationErrorDetails buildDetails = ValidationErrorDetails.builder().message(manvException.getMessage()).build();
		
		return new ResponseEntity<>(buildDetails,HttpStatus.BAD_REQUEST); 
		
		
	}
	
}
