package com.tecxter.payload;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class CustomExceptionResponse {

	private Date date;
	private String message;
	private String details;
}
