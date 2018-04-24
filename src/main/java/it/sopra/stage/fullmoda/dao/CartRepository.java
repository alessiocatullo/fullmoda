package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	public Cart findByUserEmail(String email);
}
