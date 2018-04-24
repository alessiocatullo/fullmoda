package it.sopra.stage.fullmoda.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.sopra.stage.fullmoda.form.PswForm;

@Component
public class PswFormValidator implements Validator {

	@Override
    public boolean supports(Class<?> clazz) {
        return PswForm.class.isAssignableFrom(clazz);
    }
 
	@Override
	public void validate(Object target, Errors errors)
    {
    	PswForm user = (PswForm) target;
    	
		if(!user.getOldPsw().isEmpty() && !user.getOldPsw().equals(user.getOldpassword())) {
			 errors.rejectValue("oldPsw", "error.oldPsw");
	  	}
		if(!user.getNewPsw().isEmpty() && (user.getNewPsw().length() < 4 || user.getNewPsw().length() > 20)) {
			 errors.rejectValue("newPsw", "error.newPsw");
	  	}
		if(!user.getNewPsw().equals(user.getRepPsw()) && !user.getNewPsw().isEmpty() && !user.getRepPsw().isEmpty()) {
			 errors.rejectValue("repPsw", "error.repPsw");
	  	}

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldPsw", "NotEmpty.pswForm.oldPsw", "Il campo non può essere vuoto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPsw", "NotEmpty.pswForm.newPsw", "Il campo non può essere vuoto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repPsw", "NotEmpty.pswForm.repPsw", "Il campo non può essere vuoto");
    }
 }