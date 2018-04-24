package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.sopra.stage.fullmoda.model.Address;
import lombok.Data;

@Data
public class UserData implements Serializable{

	private static final long serialVersionUID = -3865741928764031868L;
	
	private long id;
	private String name;
	private String surname;
	private String email;
	private String image;
	private Address address;
	private String password;
	private String phonenumber;
	private String birthdate;
	private String birthplace;
	private String fiscalcode;
	
	public UserData() {
		
	}
	
	public UserData(long id, String name, String surname, String email, String image, Address address, String password, String phonenumber, String birthdate, String birthplace, String fiscalcode) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.image = image;
		this.address = address;
		this.password = password;
		this.phonenumber = phonenumber;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.fiscalcode = fiscalcode;
	}
	
	@Override
	public String toString() {
		return "UserData [id =" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", image=" + image + ", password=" + password + ", phonenumber=" + phonenumber + ", birthdate=" + birthdate + ", birthplace=" + birthplace + ", fiscalcode=" + fiscalcode + "]";
	}
	
}
