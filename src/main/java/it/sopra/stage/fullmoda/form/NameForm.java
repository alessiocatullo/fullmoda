package it.sopra.stage.fullmoda.form;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class NameForm {

	private long id;
	
	private String name;

	private String surname;

	private String phonenumber;

	private String birthdate;

	private String birthplace;

	private String fiscalcode;

}
