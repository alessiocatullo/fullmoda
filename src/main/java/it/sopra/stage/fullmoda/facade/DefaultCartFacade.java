package it.sopra.stage.fullmoda.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.CartConverter;
import it.sopra.stage.fullmoda.dao.UserRepository;
import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.service.CartService;
import it.sopra.stage.fullmoda.service.ProductService;

@Component
public class DefaultCartFacade implements CartFacade{

	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CartConverter cartConverter;

	@Override
	public CartData findByUserId(long idUser) {
		Cart cart = cartService.findByUserId(userRepository.findById(idUser).getId());
		return cartConverter.convert(cart);
	}

	@Override
	public int removeFromCart(long codeEntry) {
		cartService.removeFromCart(codeEntry);
		return 0;
	}

	@Override
	public int removeOnesFromCart(long codeEntry) {
		cartService.removeOnesFromCart(codeEntry);
		return 0;
	}

	@Override
	public int addToCart(String code, long userId) {
		cartService.addToCart(code, userId);
		return 0;
	}

	@Override
	public int addOnesToCart(long codeEntry) {
		cartService.addOnesToCart(codeEntry);
		return 0;
	}
}
