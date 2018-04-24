package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="size")
@Data
@NoArgsConstructor
public class Size implements Serializable{

	private static final long serialVersionUID = -1114232192533211573L;

	@Id
	@Column(name="code")
	private String code;
	

	@Override
	public String toString() {
		return "Size [code=" + code + "]";
	}


	public Size(String code) {
		this.code = code;
	}
	
}
