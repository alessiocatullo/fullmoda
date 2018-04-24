package it.sopra.stage.fullmoda.facade;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.CartConverter;
import it.sopra.stage.fullmoda.converter.UserConverter;
import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.dto.UserTypeEnum;
import it.sopra.stage.fullmoda.exception.EmailAlreadyUsed;
import it.sopra.stage.fullmoda.exception.UserAlreadyRegistered;
import it.sopra.stage.fullmoda.form.AddressForm;
import it.sopra.stage.fullmoda.form.EmailForm;
import it.sopra.stage.fullmoda.form.ImgForm;
import it.sopra.stage.fullmoda.form.NameForm;
import it.sopra.stage.fullmoda.form.PswForm;
import it.sopra.stage.fullmoda.form.RegisterForm;
import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.model.User;
import it.sopra.stage.fullmoda.service.AuthService;

@Component
public class DefaultAuthFacade implements AuthFacade{

	@Autowired
	private AuthService loginService;
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private CartConverter cartConverter;
	
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

	@Override
	public UserData updateName(NameForm editForm){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		Date date = null;
		try {
			date = format.parse(editForm.getBirthdate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User userInput = new User(editForm.getId(), editForm.getName(), editForm.getSurname(), editForm.getPhonenumber(), date, editForm.getBirthplace(), editForm.getFiscalcode());
		User user = loginService.updateName(userInput);
		UserData userData = null;
		if(user != null) {
			userData = userConverter.convert(user);
		}
		return userData;
	}

	@Override
	public CartData newCart(UserData userData) {
		Cart cart = loginService.newCart(userData);
		CartData cartData = null;
		if (cart != null) {
			cartData = cartConverter.convert(cart);
		}
		return cartData;
	}

	@Override
	public UserData updateEmail(EmailForm editEmail) throws EmailAlreadyUsed {
		User userInput = new User(editEmail.getId(), editEmail.getEmail(), 0);
		User user = loginService.updateEmail(userInput);
		UserData userData = null;
		if(user != null) {
			userData = userConverter.convert(user);
		}
		return userData;
	}

	@Override
	public UserData updateImg(ImgForm editImg) {
		User userInput = new User(editImg.getId(), editImg.getImage(), 1);
		User user = loginService.updateImg(userInput);
		UserData userData = null;
		if(user != null) {
			userData = userConverter.convert(user);
		}
		return userData;
	}
	
	@Override
	public UserData updatePsw(PswForm editPsw) {
		User userInput = new User(editPsw.getId(),editPsw.getNewPsw(), 2);
		User user = loginService.updatePsw(userInput);
		UserData userData = null;
		if(user != null) {
			userData = userConverter.convert(user);
		}
		return userData;
	}

	@Override
	public UserData updateAddress(AddressForm editAddress) {
		User userInput = new User(editAddress.getId(), editAddress.getAddress());
		User user = loginService.updateAddress(userInput);
		UserData userData = null;
		if(user != null) {
			userData = userConverter.convert(user);
		}
		return userData;
	}
}
