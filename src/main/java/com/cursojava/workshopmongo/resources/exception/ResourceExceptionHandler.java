package com.cursojava.workshopmongo.resources.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cursojava.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(
			System.currentTimeMillis(), 
			status.value(), 
			"Não Encontrado", 
			e.getMessage(), 
			request.getRequestURI()
		);
		return ResponseEntity.status(status).body(err);
	}
}
