package it.sopra.stage.fullmoda.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.UserConverter;
import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.dto.UserTypeEnum;
import it.sopra.stage.fullmoda.exception.UserAlreadyRegistered;
import it.sopra.stage.fullmoda.form.RegisterForm;
import it.sopra.stage.fullmoda.model.User;
import it.sopra.stage.fullmoda.service.AuthService;

@Component
public class DefaultAuthFacade implements AuthFacade{

	@Autowired
	private AuthService loginService;
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public UserData validateUser(String email, String password) {
		
		User user = loginService.validateUser(email, password);
		UserData userData = null;
		if(user != null) {
			userData = userConverter.convert(user);
		}
		return userData;
	}

	@Override
	public UserData register(RegisterForm registerForm, UserTypeEnum.USERTYPE userType) throws UserAlreadyRegistered  {
		User userInput = new User(registerForm.getName(), registerForm.getSurname(), userType.name(), registerForm.getEmail(), registerForm.getPassword(), registerForm.isPrivacy());
		User user = loginService.registerUser(userInput);
		UserData userData = null;
		if(user != null) {
			userData = userConverter.convert(user);
		}
		return userData;
	}

}
