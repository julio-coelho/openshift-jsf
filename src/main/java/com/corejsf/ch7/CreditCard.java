package com.corejsf.ch7;

import java.io.Serializable;

public class CreditCard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5908728139866889820L;

	private String number;

	public CreditCard(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return number;
	}
}
