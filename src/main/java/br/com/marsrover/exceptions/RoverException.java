package br.com.marsrover.exceptions;

public class RoverException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public RoverException(String errorMessage) {
		super(errorMessage);
	}
	
}
