package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SizeData implements Serializable{

	private static final long serialVersionUID = 8688009414656214975L;
	
	private String code;
	
	public SizeData() {
		
	}
	public SizeData(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "SizeData [code=" + code + "]";
	}
	
	
}
