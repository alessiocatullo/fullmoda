package it.sopra.stage.fullmoda.facade;

import it.sopra.stage.fullmoda.dto.CartData;

public interface CartFacade {

	int addToCart(String productCode);
	
	CartData getCartByUser(String email);
	
	int removeFromCart(String productCode, int quantity);
}
