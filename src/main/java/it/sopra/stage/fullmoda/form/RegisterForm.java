package it.sopra.stage.fullmoda.form;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import it.sopra.stage.fullmoda.model.Address;
import lombok.Data;

@Data
public class RegisterForm {

	@Email
	@NotEmpty
	private String email;
	@NotEmpty
	private String name;
	@NotEmpty
	private String surname;
	@NotEmpty
	private String password;
	@NotEmpty
	private String passwordConfirmation;
	@NotEmpty
	private String birthdate;
	private Address address;
	private String img;
	
	@AssertTrue
	private boolean privacy;
}
