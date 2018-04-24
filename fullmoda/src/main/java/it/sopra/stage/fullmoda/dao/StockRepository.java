package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.Stock;
import it.sopra.stage.fullmoda.model.StockPK;

public interface StockRepository extends JpaRepository<Stock, StockPK> {

}
