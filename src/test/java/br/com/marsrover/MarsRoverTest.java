package br.com.marsrover;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.marsrover.exceptions.RoverException;
import br.com.marsrover.interfaces.Rover;

public class MarsRoverTest {

	@Test(expected = Test.None.class)
	public void expectRunTwoRovers() throws RoverException {
		List<Rover> rovers = new ArrayList<Rover>();
		rovers.add(new RoverImpl("1 2 N", "LMLMLMLMM"));
		rovers.add(new RoverImpl("3 3 E", "MMRMMRMRRM"));
		Nasa nasa = new Nasa(new Mars(5, 5), rovers);
		nasa.moveRovers();
	}
	
	@Test(expected = Test.None.class)
	public void expectRunOneRoverAndStopOther() throws RoverException {
		List<Rover> rovers = new ArrayList<Rover>();
		rovers.add(new RoverImpl("1 2 N", "LMLMLMLMM"));
		rovers.add(new RoverImpl("20 33 E", "MMRMMRMRRM"));
		Nasa nasa = new Nasa(new Mars(5, 5), rovers);
		nasa.moveRovers();
	}
	
	@Test(expected = RoverException.class)
	public void expectThrowRoverExceptionWithIcorrectPositionDirection() throws RoverException {
		List<Rover> rovers = new ArrayList<Rover>();
		rovers.add(new RoverImpl("1 2 J", "LMLMLMLMM"));
		rovers.add(new RoverImpl("3 3 K", "MMRMMRMRRM"));
		Nasa nasa = new Nasa(new Mars(5, 5), rovers);
		nasa.moveRovers();
	}
	
	@Test(expected = RoverException.class)
	public void expectThrowRoverExceptionWithIncorrectPositionParams() throws RoverException {
		List<Rover> rovers = new ArrayList<Rover>();
		rovers.add(new RoverImpl("1 2 3 J", "LMLMLMLMM"));
		rovers.add(new RoverImpl("3 3 5 5 K", "MMRMMRMRRM"));
		rovers.add(new RoverImpl(" S", "MMRMMRMRRM"));
		Nasa nasa = new Nasa(new Mars(5, 5), rovers);
		nasa.moveRovers();
	}
	
	@Test(expected = RoverException.class)
	public void expectThrowRoverExceptionWithAreaCannotBeNull() throws RoverException {
		List<Rover> rovers = new ArrayList<Rover>();
		rovers.add(new RoverImpl("1 2 N", "LMLMLMLMM"));
		rovers.add(new RoverImpl("3 3 E", "MMRMMRMRRM"));
		Nasa nasa = new Nasa(null, rovers);
		nasa.moveRovers();
	}
	
	@Test(expected = RoverException.class)
	public void expectThrowRoverExceptionWithThereIsntRovers() throws RoverException {
		Nasa nasa = new Nasa(new Mars(5, 5), null);
		nasa.moveRovers();
	}
	
	@Test(expected = NumberFormatException.class)
	public void expectThrowRoverExceptionWithIcorrectIntPosition() throws RoverException {
		List<Rover> rovers = new ArrayList<Rover>();
		rovers.add(new RoverImpl("1 2N S", "LMLMLMLMM"));
		rovers.add(new RoverImpl("33J 3 E", "MMRMMRMRRM"));
		Nasa nasa = new Nasa(new Mars(5, 5), rovers);
		nasa.moveRovers();
	}

}
