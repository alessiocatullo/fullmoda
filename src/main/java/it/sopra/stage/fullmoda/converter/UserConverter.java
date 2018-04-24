package it.sopra.stage.fullmoda.converter;

import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.model.User;

@Component
public class UserConverter {

	public UserData convert(User user) {
		UserData userData = new UserData(user.getId(), user.getName(), user.getSurname(), user.getEmail());
		return userData;
	}
}
