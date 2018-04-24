package it.sopra.stage.fullmoda.converter;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.model.User;

@Component
public class UserConverter {

	public UserData convert(User user) {
		UserData userData = new UserData(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getImage(), 
				user.getAddress(), user.getPassword(), user.getPhoneNumber(), new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthDate()), user.getBirthPlace(), 
				user.getFiscalCode());
		return userData;
	}
}
