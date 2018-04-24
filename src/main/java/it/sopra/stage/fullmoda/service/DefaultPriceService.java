package it.sopra.stage.fullmoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dao.PriceRepository;
import it.sopra.stage.fullmoda.model.Price;

@Component
public class DefaultPriceService implements PriceService{

	@Autowired
	private PriceRepository priceRepository;
	
	@Override
	public Price findProductPrice(String productCode, String currencyCode) {
		
		return priceRepository.findByBaseProductCodeAndCurrencyCode(productCode, currencyCode);
	}

}
