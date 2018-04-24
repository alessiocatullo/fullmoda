package it.sopra.stage.fullmoda.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.sopra.stage.fullmoda.form.EmailForm;
import it.sopra.stage.fullmoda.form.PswForm;

@Component
public class EmailFormValidator implements Validator {

	@Override
    public boolean supports(Class<?> clazz) {
        return EmailFormValidator.class.isAssignableFrom(clazz);
    }
 
	@Override
	public void validate(Object target, Errors errors)
    {
    	EmailForm user = (EmailForm) target;
    	
		if(!user.getPassword().equals(user.getOldpassword())) {
			 errors.rejectValue("password", "error.psw");
	  	}
		if(user.getEmail().equals(user.getOldemail())) {
			 errors.rejectValue("email", "error.email");
	  	}
    }
 }