package br.com.marsrover;

import br.com.marsrover.interfaces.ExplorablePlanetArea;

public class Mars implements ExplorablePlanetArea {
	private int limitFieldX;
	private int limitFieldY;
	
	public Mars(int limitFieldX, int limitFieldY) {
		this.limitFieldX = limitFieldX;
		this.limitFieldY = limitFieldY;
	}
	public int limitFieldX() {
		return limitFieldX;
	}
	public int limitFieldY() {
		return limitFieldY;
	}
	
	@Override
	public String toString() {
		return "x = " + limitFieldX + " y = " + limitFieldY;
	}

}
