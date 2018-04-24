package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CurrencyData implements Serializable{

	private static final long serialVersionUID = -4341873728484061806L;
	
	private String code;
	private String symbol;
	
	public CurrencyData() {
		
	}
	
	public CurrencyData(String code, String symbol) {
		this.code = code;
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return "CurrencyData [code=" + code + ", symbol=" + symbol + "]";
	}
	
	
	
}
