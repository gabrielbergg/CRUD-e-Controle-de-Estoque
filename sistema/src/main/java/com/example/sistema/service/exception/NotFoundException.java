package com.example.sistema.service.exception;

public class NotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NotFoundException(Object id) {
		super("Erro. Id: " +id);
	}
}
