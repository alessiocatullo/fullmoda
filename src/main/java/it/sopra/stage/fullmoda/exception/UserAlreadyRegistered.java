package it.sopra.stage.fullmoda.exception;

public class UserAlreadyRegistered extends Exception{

	private static final long serialVersionUID = -2178541470789069819L;

	public UserAlreadyRegistered(String message) {
		super(message);
	}
}
