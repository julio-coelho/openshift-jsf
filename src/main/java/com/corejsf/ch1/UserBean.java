package com.corejsf.ch1;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("user")
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4685615311320496021L;
	private String name = "";
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getGreeting() {
		
		if (name.length() == 0) {
			
			return "";
			
		} else {
			
			return "Welcome to JSF2 + Ajax, " + name + " !";
		}
	}
	
}
