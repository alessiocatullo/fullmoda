package it.sopra.stage.fullmoda.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 14906121048180977L;
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="type")
	private String customerType;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phonenumber")
	private String phoneNumber;
	
	@Column(name="birthdate")
	private Date birthDate;
	
	@Column(name="birthplace")
	private String birthPlace;
	
	@Column(name="privacy_agreement")
	private boolean privacyAgreement;
	
	@Column(name="fiscalcode")
	private String fiscalCode;
	
	@OneToOne (cascade= CascadeType.ALL)
	@JoinColumn(name="address")
	private Address address;
	
	@Column(name="image")
	private String image;

	public User(String name, String surname, String customerType, String email,
			String password, String phoneNumber, Date birthDate, String birthPlace, boolean privacyAgreement,
			String fiscalCode, Address address, String image) {
	
		this.name = name;
		this.surname = surname;
		this.customerType = customerType;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.privacyAgreement = privacyAgreement;
		this.fiscalCode = fiscalCode;
		this.address = address;
		this.image = image;
	}
	
	public User(long id, String name, String surname, String phonenumber, Date birthDate, String birthplace, String fiscalcode) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phonenumber;
		this.birthDate = birthDate;
		this.birthPlace = birthplace;
		this.fiscalCode = fiscalcode;
	}
	
	public User(long id, String psw_email_img, int dummy) {
		if (dummy == 2) {
			this.id = id;
			this.password = psw_email_img;
		}
		else if ( dummy == 1){
			this.id = id;
			this.image = psw_email_img;
		}
		else if ( dummy == 0){
			this.id = id;
			this.email = psw_email_img;
		}
	}

	public User(long id, Address address) {
		this.id = id;
		this.address = address;
	}

	public User(String name, String surname, String customerType, String email, String password, Date birthDate, Address address,
			boolean privacyAgreement, String image) {
		this.name = name;
		this.surname = surname;
		this.customerType = customerType;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.address = address;
		this.privacyAgreement = privacyAgreement;
		this.image = image;
	}
}
