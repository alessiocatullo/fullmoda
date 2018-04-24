package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LanguageData implements Serializable{
	
	private static final long serialVersionUID = 4562947861148840747L;
	
	private String isocode;
	private String name;
	
	public LanguageData() {
		
	}
	public LanguageData(String isocode, String name) {
		this.isocode = isocode;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "LanguageData [isocode=" + isocode + ", name=" + name + "]";
	}
	
	
}
