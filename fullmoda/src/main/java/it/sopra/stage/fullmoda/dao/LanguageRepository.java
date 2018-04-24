package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.Language;

public interface LanguageRepository extends JpaRepository<Language, String> {

}
