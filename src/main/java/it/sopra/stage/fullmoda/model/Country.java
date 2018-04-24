package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="country")
@Data
@NoArgsConstructor
public class Country implements Serializable {

	private static final long serialVersionUID = -1881333917860218320L;

	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;

	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
	
}
