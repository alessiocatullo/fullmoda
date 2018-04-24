package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, String> {

}
