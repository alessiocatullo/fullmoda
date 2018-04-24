package it.sopra.stage.fullmoda.facade;

import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.dto.SizeVariantProductData;

public interface CartFacade {

	int addToCart(String code, long userId);
	
	int addOnesToCart(long codeEntry);
	
	CartData findByUserId(long idUser);
	
	int removeFromCart(long codeEntry);
	
	int removeOnesFromCart(long codeEntry);
}
