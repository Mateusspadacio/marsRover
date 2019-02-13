package br.com.marsrover.enums;

public enum Moviments {
	M("M"), R("R"), L("L");

	private String moviment;
	
	Moviments(String moviment) {
		this.moviment = moviment;
	}
	
	@Override
	public String toString() {
		return moviment;
	}

}
