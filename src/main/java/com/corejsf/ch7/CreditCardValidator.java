package com.corejsf.ch7;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.corejsf.ch7.util.Messages;

@FacesValidator("com.corejsf.ch7.Card")
public class CreditCardValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		if (value == null) {
			return;
		}
		
		String cardNumber;
		
		if (value instanceof CreditCard) {
			cardNumber = value.toString();
		} else {
			cardNumber = value.toString().replaceAll("\\D", "");
		}
		
		if (!luhnCheck(cardNumber)) {
			FacesMessage message = Messages.getMessage("com.corejsf.ch7.messages", "badLuhnCheck", null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

	}

	private static boolean luhnCheck(String cardNumber) {
		
		int sum = 0;
		
		for (int i = cardNumber.length() - 1; i >= 0; i -= 2) {
			sum += Integer.parseInt(cardNumber.substring(i, i + 1));
			
			if (i > 0) {
				int d = 2 * Integer.parseInt(cardNumber.substring(i - 1, i));
				
				if (d > 9) {
					d -= 9;
				}
				
				sum += d;
			}
		}
		
		return sum % 10 == 0;
	}

}
