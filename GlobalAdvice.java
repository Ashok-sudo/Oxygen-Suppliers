package com.oxygen.controller.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.oxygen.response.GlobalErrorResponse;

@ControllerAdvice
public class GlobalAdvice {

	@ExceptionHandler
	public ResponseEntity<Object> handleExeption(Exception e) {
		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(false);
		errorResponse.setDescription("while processing error occured");
		return new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
