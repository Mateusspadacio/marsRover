package br.com.marsrover;

import java.util.List;

import br.com.marsrover.exceptions.RoverException;
import br.com.marsrover.interfaces.ExplorablePlanetArea;
import br.com.marsrover.interfaces.Rover;

public class Nasa {
	
	ExplorablePlanetArea area;
	List<Rover> rovers;
    
    public Nasa(ExplorablePlanetArea area, List<Rover> rovers) {
    	this.area = area;
    	this.rovers = rovers;
    }
    
    public void moveRovers() throws RoverException {
		if (area == null) throw new RoverException("area cannot be null");
		if (rovers == null || rovers.size() == 0) throw new RoverException("There isn't rovers");
		
    	for (int i = 0; i < rovers.size(); i++) { 
    		try {
    			rovers.get(i).execMoviments(area);
    			System.out.println(rovers.get(i));
			} catch (RoverException e) {
				System.out.println(e.getMessage());
			}
    	}
    }
    
}
