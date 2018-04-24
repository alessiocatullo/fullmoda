package it.sopra.stage.fullmoda.service;


import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dao.CartEntryRepository;
import it.sopra.stage.fullmoda.dao.CartRepository;
import it.sopra.stage.fullmoda.dao.SizeVariantProductRepository;
import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.model.CartEntry;
import it.sopra.stage.fullmoda.model.SizeVariantProduct;

@Component
public class DefaultCartService implements CartService {

	private static final Logger logger = Logger.getLogger(DefaultCartService.class);
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartEntryRepository cartEntryRepository;
	@Autowired
	private SizeVariantProductRepository sizeVariantRepository;
	
	@Override
	public int addToCart(String sizeVariantProductCode, long userId) {
		SizeVariantProduct product = sizeVariantRepository.findByCode(sizeVariantProductCode);
		Cart cart = cartRepository.findByUserId(userId);
		CartEntry cartEntry = findByCartAndProduct(cart.getId(), sizeVariantProductCode);
		
		if(cartEntry == null) {
			CartEntry temp = new CartEntry(product, 1);
			temp.setCart(cart);
			System.out.println(temp);
			cartEntryRepository.save(temp);
		}
		else {
			CartEntry temp = findByCartAndProduct(cart.getId(), sizeVariantProductCode);
			addOnesToCart(temp.getEntryId());
		}
		return 0;
	}

	@Override
	public Cart findByUserId(long id) {
		Cart cart = cartRepository.findByUserId(id);
		logger.info(cart);
		return cart;
	}

	@Override
	@Transactional
	public int removeFromCart(long codeEntry) {
		cartEntryRepository.delete(cartEntryRepository.findByEntryId(codeEntry));
		return 0;
	}

	@Override
	@Transactional
	public int removeOnesFromCart(long codeEntry) {
		CartEntry temp = cartEntryRepository.findByEntryId(codeEntry);
		temp.setQuantity(temp.getQuantity()-1);
		return 0;
	}

	@Override
	public int addOnesToCart(long codeEntry) {
		CartEntry temp = cartEntryRepository.findByEntryId(codeEntry);
		temp.setQuantity(temp.getQuantity()+1);
		return 0;
	}

	@Override
	public CartEntry findByCartAndProduct(Long cartId, String productCode) {
		Cart cart = cartRepository.findById(cartId);
		SizeVariantProduct size = sizeVariantRepository.findByCode(productCode);
		return cartEntryRepository.findByCartAndProduct(cart, size);
	}
}
