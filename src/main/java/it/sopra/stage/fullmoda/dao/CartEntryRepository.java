package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.model.CartEntry;
import it.sopra.stage.fullmoda.model.SizeVariantProduct;

public interface CartEntryRepository extends JpaRepository<CartEntry, Long> {

	CartEntry findByEntryId(long code);
	
	CartEntry findByCartAndProduct(Cart cart, SizeVariantProduct size);
}
