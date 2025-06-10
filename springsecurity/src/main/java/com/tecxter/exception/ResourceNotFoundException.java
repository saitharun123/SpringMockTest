package com.tecxter.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

	private Long id;
	private String fieldName;
	private String fieldValue;
	public ResourceNotFoundException(Long id) {
		super(String.format("Resource not found with ID : '%s'",id));
		this.id = id;
		
	}
	
	
}
