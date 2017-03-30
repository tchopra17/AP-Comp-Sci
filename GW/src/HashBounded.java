import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap; 
/**
 * list <code>BoundedGrid</code> is list rectangular grid with list finite number of rows
 * and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class HashBounded<E> extends AbstractGrid<E> {
	private Map<Location, E> map;
	private int numRows;
	private int numCols; 

	public HashBounded(int rows, int cols){
		 map = new HashMap<Location, E>();
		 numRows = rows;
		 numCols = cols;
	} 
	
	public int getNumRows() {
		return numRows;
	}

	public int getNumCols() {
		return numCols;
	}

	public boolean isValid(Location loc) {
		return 0 <= loc.getRow() && loc.getRow() < getNumRows() && 0 <= loc.getCol() && loc.getCol() < getNumCols();
	}

	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> list = new ArrayList<Location>();
		for (Location loc : map.keySet()){
			list.add(loc);
		}
		return list; 
	}

	public E get(Location loc) {
		if (loc == null){
			 throw new NullPointerException("loc == null");
		}
		return map.get(loc); 
	}

	public E put(Location loc, E obj) {
		if (loc == null){
			 throw new NullPointerException("loc == null");
		}
		if (obj == null){
			 throw new NullPointerException("obj == null");
		}
		return map.put(loc, obj); 
	}

	public E remove(Location loc) {
		if (loc == null){
			 throw new NullPointerException("loc == null");
		}
		return map.remove(loc); 
	}
}