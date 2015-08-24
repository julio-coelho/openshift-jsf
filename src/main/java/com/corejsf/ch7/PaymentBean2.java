package com.corejsf.ch7;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Named
@SessionScoped
public class PaymentBean2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3986272311274828564L;
	
	@Min(10)
	@Max(10000)
	private double amount;

	@Size(min=13, message="com.corejsf.creditCardLength")
	@LuhnCheck
	private String card;
	
	@Future
	private Date date = new Date();

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
