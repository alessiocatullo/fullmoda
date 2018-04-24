package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);

	User findById(Long id);
}
