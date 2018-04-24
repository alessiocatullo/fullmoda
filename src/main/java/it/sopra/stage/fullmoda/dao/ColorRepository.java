package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.Color;

public interface ColorRepository extends JpaRepository<Color, String>{

	Color findByCode(String code);
}
