package it.sopra.stage.fullmoda.converter;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.CurrencyData;
import it.sopra.stage.fullmoda.dto.PriceData;
import it.sopra.stage.fullmoda.model.Price;

@Component
public class PriceConverter {

	@Autowired
	private CurrencyConverter currencyConverter;
	
	public PriceData convert (Price price) {
		BigDecimal value = price.getValue();
		CurrencyData currencyData = currencyConverter.convert(price.getCurrency());
		return new PriceData(value, currencyData);
	}
}
