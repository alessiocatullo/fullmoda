package it.sopra.stage.fullmoda.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import it.sopra.stage.fullmoda.dao.UserRepository;
import it.sopra.stage.fullmoda.exception.UserAlreadyRegistered;
import it.sopra.stage.fullmoda.model.User;

@Service
public class DefaultAuthService implements AuthService{

	private static final Logger LOG = Logger.getLogger(DefaultAuthService.class);
	
	@Autowired
	private UserRepository userRepository;
	
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

}
