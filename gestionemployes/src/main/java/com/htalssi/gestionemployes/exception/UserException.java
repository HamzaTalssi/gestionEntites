package com.htalssi.gestionemployes.exception;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class UserException extends RuntimeException {
	
	private String message;

}
