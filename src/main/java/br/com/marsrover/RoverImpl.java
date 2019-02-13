package br.com.marsrover;

import br.com.marsrover.enums.CardinalPoints;
import br.com.marsrover.enums.Moviments;
import br.com.marsrover.exceptions.RoverException;
import br.com.marsrover.interfaces.ExplorablePlanetArea;
import br.com.marsrover.interfaces.Rover;

public class RoverImpl implements Rover {
	
	private int x;
	private int y;
	private int directionPoint;
	private String[] moviments;
	private ExplorablePlanetArea area;
	
	public RoverImpl(String position, String moviments) throws RoverException {
		splitPosition(position);
		this.moviments = moviments.trim().split(""); 
	}
	
	public void execMoviments(ExplorablePlanetArea area) throws RoverException {
		if (area == null) throw new RoverException("area cannot be null");
		this.area = area;
		
		for (int i = 0; i < moviments.length; i++) {
			String moviment = moviments[i];
			
			if (moviment.equals(Moviments.R.toString())) {
				directionPoint++;
			}
			
			if (moviment.equals(Moviments.L.toString())) {
				directionPoint--;
			}
			
			int cardinalLength = CardinalPoints.values().length;
			if (directionPoint >= cardinalLength) {
				directionPoint = 0;
				continue;
			} else if (directionPoint < 0) {
				directionPoint = cardinalLength - 1;
				continue;
			}
			
			if (moviment.equals(Moviments.M.toString())) {
				move();
			}
			
		}
	}
	
	private void move() throws RoverException {
		CardinalPoints direction = CardinalPoints.values()[directionPoint];
		
		switch(direction) {
			case W:
				if (x - 1 < 0) throw new RoverException(limitErrorMessage());
				x--;
				break;
			case N:
				if (y + 1 > area.limitFieldY()) throw new RoverException(limitErrorMessage());
				y++;
				break;
			case E:
				if (x + 1 > area.limitFieldX()) throw new RoverException(limitErrorMessage());
				x++;
				break;
			case S:
				if (y - 1 < 0) throw new RoverException(limitErrorMessage());
				y--;
				break;
		}
	}
	
	private void splitPosition(String position) throws RoverException {
		String[] splitedPosition = position.trim().split(" ");
		
		if(splitedPosition.length != 3) {
			throw new RoverException("Incorrect position input");
		}
		
		x = Integer.parseInt(splitedPosition[0]);
		y = Integer.parseInt(splitedPosition[1]);
		directionPoint = CardinalPoints.findOrdinal(splitedPosition[2]);
		
		if (directionPoint == -1) {
			throw new RoverException("Incorrect direction");
		}
	}

	private String limitErrorMessage() {
		return "Rover [" + toString() + "] cannot movie outside " + area.getClass().getSimpleName() + " limit area " + area;
	}
	
	@Override
	public String toString() {
		return x + " " + y + " " + CardinalPoints.values()[directionPoint];
	}
	
}
