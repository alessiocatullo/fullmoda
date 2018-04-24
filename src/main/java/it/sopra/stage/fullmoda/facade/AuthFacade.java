package it.sopra.stage.fullmoda.facade;

import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.dto.UserTypeEnum;
import it.sopra.stage.fullmoda.exception.UserAlreadyRegistered;
import it.sopra.stage.fullmoda.form.RegisterForm;

public interface AuthFacade {

	UserData validateUser(String email, String password);
		
	UserData register(RegisterForm registerForm, UserTypeEnum.USERTYPE userType) throws UserAlreadyRegistered;
	
}
