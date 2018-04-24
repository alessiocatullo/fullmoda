package it.sopra.stage.fullmoda.form;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class EmailForm {

	private long id;

	private String email;

	private String password;
	
	private String oldpassword;
	
	private String oldemail;
}
