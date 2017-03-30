import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList; 

public class QuickCrab extends CrabCritter{
	public QuickCrab() {
		setColor(Color.RED);
	}
	public ArrayList<Location> getMoveLocations() {
		
		ArrayList<Location> l = new ArrayList<Location>();
		Grid g = getGrid();
		
		addTwo(l,getDirection() + Location.LEFT);
		addTwo(l,getDirection() + Location.RIGHT);

		if (l.size() == 0){
			return super.getMoveLocations();
		}
		
		return l;
	 } 
	 public void addTwo(ArrayList<Location> l,int d) {
		
		Location location = getLocation();
		Location temporary = location.getAdjacentLocation(d);
		Grid grid = getGrid();
		
		if(grid.isValid(temporary) && grid.get(temporary) == null) {
			Location location2 = temporary.getAdjacentLocation(d);
	 
			if(grid.isValid(location2) && grid.get(location2)== null){
				l.add(location2);
			}
			
		}
	 } 
}
