package com.corejsf.ch7;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PaymentBean3 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5174149873485832242L;

	private double amount;
	private CreditCard card = new CreditCard("");
	private Date date = new Date();
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public CreditCard getCard() {
		return card;
	}
	public void setCard(CreditCard card) {
		this.card = card;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
