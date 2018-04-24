package it.sopra.stage.fullmoda.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class PswForm {

	private long id;
	
	private String oldPsw;

	private String newPsw;

	private String repPsw;
	
	private String oldpassword;
}
