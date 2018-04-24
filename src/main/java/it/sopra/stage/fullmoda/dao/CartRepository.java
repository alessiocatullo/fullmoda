package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	Cart findByUserId(long i);
	Cart findById(long i);
	public Cart findByUserEmail(String email);
}
