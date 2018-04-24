package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, String> {

}
