package com.example.mnsproject.exceptions;

/**
 * 
 * @author angelcereijo
 *
 */
public class MnsLoginException extends Exception {

	private static final long serialVersionUID = 235245231273952994L;
	
	private static final String ERROR = "Usuario/Clave incorrecto";
	
	
	@Override
	public String getMessage() {
		return ERROR;
	}

}
