package br.com.marsrover.interfaces;

import br.com.marsrover.exceptions.RoverException;

public interface Rover {

	public void execMoviments(ExplorablePlanetArea area) throws RoverException;
	
}
