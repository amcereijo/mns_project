package com.example.mnsproject.dtos;

import java.io.Serializable;

/**
 * Msn user dto
 * @author angelcereijo
 *
 */
public class MnsUserDto implements Serializable {

	private static final long serialVersionUID = -7667076584992986993L;
	
	
	private String user;
	private String password;
	private String sessionId;
	
	public void MsnUserDto() {

	}
	
	public void MsnUserDto(String user, String password) {
		setUser(user);
		setPassword(password);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getSessionId() {
		return sessionId;
	}
	
	
}
