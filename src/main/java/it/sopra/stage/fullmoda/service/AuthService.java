package it.sopra.stage.fullmoda.service;

import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.exception.EmailAlreadyUsed;
import it.sopra.stage.fullmoda.exception.UserAlreadyRegistered;
import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.model.User;

public interface AuthService {

	User validateUser(String email, String password);
	
	User registerUser(User user) throws UserAlreadyRegistered;
	
	User updateEmail(User user) throws EmailAlreadyUsed;

	User updateName(User user);
	
	User updatePsw(User user);
	
	User updateImg(User user);
	
	User updateAddress(User user);
		
	Cart newCart(UserData userData);
}
