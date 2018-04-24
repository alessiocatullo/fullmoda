package it.sopra.stage.fullmoda.facade;

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

public interface AuthFacade {

	UserData validateUser(String email, String password);
	
	UserData register(RegisterForm registerForm, UserTypeEnum.USERTYPE userType) throws UserAlreadyRegistered;
	
	UserData updateName(NameForm editName);
	
	UserData updateEmail(EmailForm editEmail) throws EmailAlreadyUsed;

	UserData updatePsw(PswForm editPsw);

	UserData updateImg(ImgForm editImg);
	
	UserData updateAddress(AddressForm editAddress);
	
	CartData newCart(UserData userData);
}
