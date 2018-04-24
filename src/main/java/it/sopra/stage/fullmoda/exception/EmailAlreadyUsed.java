package it.sopra.stage.fullmoda.exception;

public class EmailAlreadyUsed extends Exception{

	private static final long serialVersionUID = 1L;

	public EmailAlreadyUsed(String message) {
		super(message);
	}
}
