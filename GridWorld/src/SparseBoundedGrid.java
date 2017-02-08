import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class SparseBoundedGrid<E> extends AbstractGrid<E>{
	private SparseBoundedGridNode[] occupantArray;
	private int numCols;
	private int numRows;

  public SparseBoundedGrid(int rows, int cols){
	  if (rows <= 0){
		  throw new IllegalArgumentException("rows <= 0");
	  }
	  if (cols <= 0) {
		  throw new IllegalArgumentException("cols <= 0");
	  }
	  numCols = cols;
	  numRows = rows;
	  occupantArray = new SparseBoundedGridNode[rows];
  	}
  	public int getNumRows(){
  		return numRows;
  	}
  	public int getNumCols(){
  		return numCols;
  	}
  	public boolean isValid(Location loc){
	  return 0 <= loc.getRow() && loc.getRow() < getNumRows() && 0 <= loc.getCol() && loc.getCol() < getNumCols();
  	}
  	public ArrayList<Location> getOccupiedLocations(){
  		ArrayList<Location> theLocations = new ArrayList<Location>();
  		for (int r = 0; r < getNumRows(); r++){
  			SparseBoundedGridNode p = occupantArray[r];
  			while(p != null){
  				Location loc = new Location(r, p.getColumn());
  				theLocations.add(loc);
  				p = p.getNext();
  			} 
  		}
  		return theLocations;
  	}
  	public E get(Location loc){
  		if (!isValid(loc)){
  			throw new IllegalArgumentException("Location " + loc + " is not valid");
  		}
  		SparseBoundedGridNode p = occupantArray[loc.getRow()];
  		while(p != null) {
  			if(loc.getCol() == p.getColumn()){
  				return (E)p.getOccupant();
  			}
  			p = p.getNext();
  		}
  		return null;
  	}
  	public E put(Location loc, E obj){
  		if (!isValid(loc)){
  			throw new IllegalArgumentException("Location " + loc + " is not valid");
  		}
  		E oldOccupant = remove(loc);
  		SparseBoundedGridNode p = occupantArray[loc.getRow()];
  		occupantArray[loc.getRow()] = new SparseBoundedGridNode(obj,loc.getCol(), p);
  		return oldOccupant;
	}
  	public E remove(Location loc){
  		if (!isValid(loc)){
  			throw new IllegalArgumentException("Location " + loc + " is not valid");
  		}
  		E obj = get(loc);
  		if (obj == null){
  			return null;
  		}
  		SparseBoundedGridNode p = occupantArray[loc.getRow()];
  		if(p != null){
  			if(p.getColumn() == loc.getCol()){
  				occupantArray[loc.getRow()] = p.getNext();
  			}else{
  				SparseBoundedGridNode q = p.getNext();
  				while(q!= null && q.getColumn() != loc.getCol()){
  					p = p.getNext();
  					q = q.getNext();
  				}
  				if(q != null){
  					p.setNext(q.getNext());
  				}
  			} 
  		}
  		return obj; 
  	}
  }