package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

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
@Table(name="address")
@Data
@NoArgsConstructor
public class Address implements Serializable {

	private static final long serialVersionUID = -4468240752515807448L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_Address")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="line1")
	private String line1;
	
	@Column(name="line2")
	private String line2; 
	
	@Column(name="zipcode")
	private String zipCode;
	
	@Column(name="town")
	private String town;
	
	@JoinColumn(name="country_code")
	@OneToOne
	private Country country;

	
	public Address(String title, String line1, String line2, String zipCode, String town, Country country) {
		this.title = title;
		this.line1 = line1;
		this.line2 = line2;
		this.zipCode = zipCode;
		this.town = town;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", title=" + title + ", line1=" + line1 + ", line2=" + line2 + ", zipCode="
				+ zipCode + ", town=" + town + ", country=" + country + "]";
	}
	
	
}
