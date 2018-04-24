package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="payment")
@Data
@NoArgsConstructor
public class PaymentMethod implements Serializable {

	private static final long serialVersionUID = 6012181409124564952L;

	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;

	
	public PaymentMethod(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "PaymentMethod [code=" + code + ", name=" + name + "]";
	}
	
	
}
