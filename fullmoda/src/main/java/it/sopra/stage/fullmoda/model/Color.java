package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="color")
@Data
@NoArgsConstructor
public class Color implements Serializable{
	
	private static final long serialVersionUID = -1493620935407428384L;

	@Id
	@Column(name="code")
	private String code;

	@Column(name="html_code")
	private String html_code;
	
	public Color(String code, String html_code) {
		
		this.code = code;
		this.html_code = html_code;
	}
	
	@Override
	public String toString() {
		return "Color [colorCode=" + code + ", html_code=" + html_code + "]";
	}
	
}
