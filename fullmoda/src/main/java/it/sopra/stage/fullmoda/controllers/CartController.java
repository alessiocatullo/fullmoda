package it.sopra.stage.fullmoda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.facade.CartFacade;

@RestController
public class CartController {

	@Autowired
	private CartFacade cartFacade;
	
	@GetMapping("/addToCart")
	public int addToCart(final String productCode) {
		return cartFacade.addToCart(productCode);
	}
	
	@GetMapping("/removeProduct")
	public int removeProduct(final String productCode, final int quantity) {
		return cartFacade.removeFromCart(productCode, quantity);
	}
	
	@GetMapping("/cart")
	public CartData getCart(String email) {
	
		return cartFacade.getCartByUser(email);
	}
	
	
}
