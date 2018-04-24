package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.Price;
import it.sopra.stage.fullmoda.model.PricePK;

public interface PriceRepository extends JpaRepository<Price, PricePK> {

	public Price findByBaseProductCodeAndCurrencyCode(String code, String currency);
}
