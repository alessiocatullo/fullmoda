package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ColorData implements Serializable{

	private static final long serialVersionUID = -7748670728549293087L;

	private String code;
	private String htmlCode;
	
	public ColorData() {
		
	}
	
	public ColorData(String code, String htmlCode) {
		this.code = code;
		this.htmlCode = htmlCode;
	}
	
	@Override
	public String toString() {
		return "ColorData [code=" + code + ", htmlCode=" + htmlCode + "]";
	}
	
	
}
