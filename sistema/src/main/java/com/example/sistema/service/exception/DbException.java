package com.example.sistema.service.exception;

public class DbException extends RuntimeException {
	static final long serialVersionUID = 1L;

	public DbException(String msg) {
		super(msg);
	}
}
