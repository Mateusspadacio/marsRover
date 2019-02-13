package br.com.marsrover.enums;

public enum CardinalPoints {
	W("W"), N("N"), E("E"), S("S");
	
	private String direction;
	
	CardinalPoints(String direction) {
		this.direction = direction;
	}
	
	public static int findOrdinal(String direction) {
		CardinalPoints[] values = CardinalPoints.values();
		for (int i = 0; i < values.length; i++) {
			if (values[i].toString().equals(direction)) return i;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		return direction;
	}
}
