package it.sopra.stage.fullmoda.service;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dao.CartRepository;
import it.sopra.stage.fullmoda.model.Cart;

@Component
public class DefaultCartService implements CartService {

	private static final Logger logger = Logger.getLogger(DefaultCartService.class);
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public int addToCart(String productCode) {
		//TODO
		return 0;
	}

	@Override
	public Cart getCartByUser(String email) {
		Cart cart = cartRepository.findByUserEmail(email);
		logger.info(cart);
		return cart;
	}

	@Override
	public int removeFromCart(String productCode, int quantity) {
		//TODO
		return 0;
	}
}
