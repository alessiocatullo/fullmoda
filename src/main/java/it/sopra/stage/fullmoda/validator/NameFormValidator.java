package it.sopra.stage.fullmoda.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.sopra.stage.fullmoda.form.NameForm;
import it.sopra.stage.fullmoda.form.PswForm;

@Component
public class NameFormValidator implements Validator {

	@Override
    public boolean supports(Class<?> clazz) {
        return NameForm.class.isAssignableFrom(clazz);
    }
 
	@Override
	public void validate(Object target, Errors errors)
    {
    	NameForm user = (NameForm) target;
    	
		if(user.getFiscalcode().length() != 16) {
			 errors.rejectValue("fiscalcode", "error.fiscalcode");
	  	}

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.nameForm.name", "Il campo non può essere vuoto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "NotEmpty.nameForm.surname", "Il campo non può essere vuoto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phonenumber", "NotEmpty.nameForm.phonenumber", "Il campo non può essere vuoto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthdate", "NotEmpty.nameForm.bithdate", "Il campo non può essere vuoto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthplace", "NotEmpty.nameForm.birthplace", "Il campo non può essere vuoto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fiscalcode", "NotEmpty.nameForm.fiscalcode", "Il campo non può essere vuoto");
    }
 }