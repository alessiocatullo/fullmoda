package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class PriceData implements Serializable{

	private static final long serialVersionUID = 2545216780969233951L;
	
	private BigDecimal value;
	private CurrencyData currency;
	
	public PriceData() {
		
	}
	
	public PriceData(BigDecimal value, CurrencyData currency) {
		this.value = value;
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "PriceData [value=" + value + ", currency=" + currency + "]";
	}
	
	
}
