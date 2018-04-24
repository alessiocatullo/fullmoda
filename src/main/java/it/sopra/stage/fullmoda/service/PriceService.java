package it.sopra.stage.fullmoda.service;

import it.sopra.stage.fullmoda.model.Price;

public interface PriceService {

	public Price findProductPrice(String productCode, String currencyCode);
}
