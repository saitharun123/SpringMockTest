package com.tecxter.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tecxter.payload.CustomExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException rne, WebRequest request) {
		CustomExceptionResponse response = new CustomExceptionResponse();
		response.setDate(new Date());
		response.setMessage(rne.getMessage());
		response.setDetails(request.getDescription(false));
		
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<CustomExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException rne, WebRequest request) {
//		CustomExceptionResponse response = new CustomExceptionResponse();
//		response.setDate(new Date());
//		response.setMessage(rne.getMessage());
//		response.setDetails(request.getDescription(false));
//		
//		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
//	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		Map<String,String> errors = new HashMap<>();
		
		ex.getFieldErrors().stream().map(e -> errors.put(e.getField(), e.getDefaultMessage()));
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);

	}
}
