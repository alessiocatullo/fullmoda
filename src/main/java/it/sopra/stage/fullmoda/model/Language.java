package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="language")
@Data
@NoArgsConstructor
public class Language implements Serializable{
	
	private static final long serialVersionUID = -7001602948310834334L;

	@Id
	@Column (name="isocode")
	private String isocode;
	
	@Column (name="name")
	private String name;

	
	public Language(String isocode, String name) {
		this.isocode = isocode;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Language [isocode=" + isocode + ", name=" + name + "]";
	}

	
}
