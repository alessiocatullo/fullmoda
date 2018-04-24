package it.sopra.stage.fullmoda.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import it.sopra.stage.fullmoda.dao.CartRepository;
import it.sopra.stage.fullmoda.dao.UserRepository;
import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.exception.EmailAlreadyUsed;
import it.sopra.stage.fullmoda.exception.UserAlreadyRegistered;
import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.model.CartEntry;
import it.sopra.stage.fullmoda.model.Language;
import it.sopra.stage.fullmoda.model.User;
import it.sopra.stage.fullmoda.model.Website;

@Service
public class DefaultAuthService implements AuthService{

	private static final Logger LOG = Logger.getLogger(DefaultAuthService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public User validateUser(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public User registerUser(User user) throws UserAlreadyRegistered{
		User savedUser = null;
		try {
			savedUser = userRepository.save(user);
		}catch(DataIntegrityViolationException e) {
			LOG.warn(String.format("User email %s already registered, exception: %s", user.getEmail(), e.getMessage()));
			throw new UserAlreadyRegistered(String.format("User email %s already registered", user.getEmail()));
		}
		return savedUser;
	}

	@Override
	public Cart newCart(UserData userData) {
		Cart cart = cartRepository.findByUserEmail(userData.getEmail());
		if (cart == null) {
			try {
				User savedUser = userRepository.findById(userData.getId());
				cart = new Cart();
				cart.setUser(savedUser);
				Locale l = Locale.ITALIAN; 
				cart.setCreated(new Date());
				cart.setLastModified(new Date());
				cart.setCartEntries(new ArrayList<CartEntry>());
				cart.setWebsite(new Website("fullmoda_it", new Language(l.getLanguage(), "Italiano")));
				cartRepository.save(cart);
			}
			catch (Exception ex) {
				
			}
		}
		
		return cart;
	}

	@Override
	public User updateImg(User user) {
		User savedUser = userRepository.findById(user.getId());
 		try {
 			try {
				savedUser.setImage(user.getImage());
				userRepository.save(savedUser);
			}
			catch(Exception ex){
				LOG.warn(ex.getMessage());
			}
		}catch(DataIntegrityViolationException e) {
			LOG.warn(String.format("Errors while udpating user, exception: %s", e.getMessage()));
		}
		return savedUser;
	}

	@Override
	public User updateAddress(User user) {
		User savedUser = userRepository.findById(user.getId());
 		try {
 			try {
				savedUser.setAddress(user.getAddress());
				userRepository.save(savedUser);
			}
			catch(Exception ex){
				LOG.warn(ex.getMessage());
			}
		}catch(DataIntegrityViolationException e) {
			LOG.warn(String.format("Errors while udpating address, exception: %s", e.getMessage()));
		}
		return savedUser;
	}

	@Override
	public User updateEmail(User user) throws EmailAlreadyUsed {
		User savedUser = userRepository.findById(user.getId());
 		try {
			try {
 				savedUser.setEmail(user.getEmail());
 				userRepository.save(savedUser);
			}
			catch(DataIntegrityViolationException ex){
				LOG.warn(ex.getMessage());
				throw new EmailAlreadyUsed(String.format("User email %s already used", user.getEmail()));
			}
		}catch(DataIntegrityViolationException e) {
			LOG.warn(String.format("Errors while udpating address, exception: %s", e.getMessage()));
		}
		return savedUser;
	}

	@Override
	public User updateName(User user) {
		User savedUser = userRepository.findById(user.getId());
 		try {
			try {
 				savedUser.setName(user.getName());
 				savedUser.setSurname(user.getSurname());
 				savedUser.setPhoneNumber(user.getPhoneNumber());
 				savedUser.setBirthDate(user.getBirthDate());
 				savedUser.setBirthPlace(user.getBirthPlace());
 				savedUser.setFiscalCode(user.getFiscalCode());
 				userRepository.save(savedUser);
			}
			catch(Exception ex){
				LOG.warn(ex.getMessage());
			}
		}catch(DataIntegrityViolationException e) {
			LOG.warn(String.format("Errors while udpating address, exception: %s", e.getMessage()));
		}
		return savedUser;
	}

	@Override
	public User updatePsw(User user) {
		User savedUser = userRepository.findById(user.getId());
 		try {
			try {
				savedUser.setPassword(user.getPassword());
				userRepository.save(savedUser);
			}
			catch(Exception ex){
				LOG.warn(ex.getMessage());
			}
		}catch(DataIntegrityViolationException e) {
			LOG.warn(String.format("Errors while udpating address, exception: %s", e.getMessage()));
		}
		return savedUser;
	}

}
