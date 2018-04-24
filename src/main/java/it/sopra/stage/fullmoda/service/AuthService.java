package it.sopra.stage.fullmoda.service;

import it.sopra.stage.fullmoda.exception.UserAlreadyRegistered;
import it.sopra.stage.fullmoda.model.User;

public interface AuthService {

	User validateUser(String email, String password);
	
	User registerUser(User user) throws UserAlreadyRegistered;
}
