package it.sopra.stage.fullmoda.converter;

import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.CurrencyData;
import it.sopra.stage.fullmoda.model.Currency;

@Component
public class CurrencyConverter {

	public CurrencyData convert(Currency currency) {
		return new CurrencyData(currency.getCode(), currency.getSymbol());
	}
}
