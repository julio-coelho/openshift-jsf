package com.corejsf.ch7;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import com.corejsf.ch7.util.Messages;

@Named
@SessionScoped
public class BackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6783621362582656795L;

	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public void validateDate(FacesContext context, UIComponent component, Object value) {
	
		UIInput dayInput = (UIInput) component.findComponent("day");
		UIInput monthInput = (UIInput) component.findComponent("month");
		
		int d = ((Integer) dayInput.getLocalValue()).intValue();
		int m = ((Integer) monthInput.getLocalValue()).intValue();
		int y = ((Integer) value).intValue();
		
		if (!isValidDate(d,m,y)) {
			FacesMessage message = Messages.getMessage("com.corejsf.ch7.messages", "invalidDate", null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);	
			
		}
		
	}
	
	private boolean isValidDate(int d, int m, int y) {
		
		if (d < 1 || m < 1 || m > 12) {
			return false;
		}
		
		if (m == 2) {
			if (isLeapYear(y)) {
				return d <= 29;
			} else {
				return d <= 28;
			}
		} else if (m == 4 || m == 6 || m == 9 || m == 11) {
			return d <= 30;
		} else {
			return d <= 31;
		}
	}
	
	private boolean isLeapYear(int y) {
		
		if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) {
			return true;
		}
		return false;
	}
	
}
