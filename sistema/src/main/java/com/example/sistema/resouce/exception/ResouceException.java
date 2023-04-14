package com.example.sistema.resouce.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.sistema.service.exception.DbException;
import com.example.sistema.service.exception.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResouceException {

	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(NotFoundException e, HttpServletRequest request) {
		String error = "Resouce não achado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	
	@ExceptionHandler(DbException.class)
	public ResponseEntity<StandardError> database(DbException e, HttpServletRequest request) {
		String error = "DataBase error. ";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	
}
