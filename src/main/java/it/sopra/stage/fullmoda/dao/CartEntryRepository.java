package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.CartEntry;

public interface CartEntryRepository extends JpaRepository<CartEntry, Long> {

}
