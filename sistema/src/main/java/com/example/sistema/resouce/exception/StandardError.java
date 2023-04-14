package com.example.sistema.resouce.exception;


import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Instant dateTime;
	private Integer status;
	private String error;
	private String mensage;
	private String path;
	
	
	public StandardError() {
	}


	public StandardError(Instant dateTime, Integer status, String error, String mensage, String path) {
		this.dateTime = dateTime;
		this.status = status;
		this.error = error;
		this.mensage = mensage;
		this.path = path;
	}


	public Instant getdateTime() {
		return dateTime;
	}

	public void setdateTime(Instant dateTime) {
		this.dateTime = dateTime;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}


	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}


	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
