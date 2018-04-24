package it.sopra.stage.fullmoda.service;

import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.model.CartEntry;

public interface CartService {

	int addToCart(String sizeVariantProductCode, long userId);
	
	int addOnesToCart(long codeEntry);
	
	Cart findByUserId(long id);
	
	CartEntry findByCartAndProduct(Long cartId, String productCode);
	
	int removeFromCart(long codeEntry);
	
	int removeOnesFromCart(long codeEntry);
}
