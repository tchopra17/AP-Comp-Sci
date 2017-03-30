import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A <code>BoundedGrid</code> is a rectangular grid with a finite number of rows
 * and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class SparseBoundedGrid<E> extends AbstractGrid<E> {
	private ArrayList<LinkedList> occupantArray; // the array storing
	// the grid elements
	private int numCols;
	private int numRows;

	/**
	 * Constructs an empty bounded grid with the given dimensions.
	 * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
	 * 
	 * @param rows
	 *            number of rows in BoundedGrid
	 * @param cols
	 *            number of columns in BoundedGrid
	 */
	public SparseBoundedGrid(int rows, int cols) {
		if (rows <= 0)
			throw new IllegalArgumentException("rows <= 0");
		if (cols <= 0)
			throw new IllegalArgumentException("cols <= 0");
		numCols = cols;
		numRows = rows;
		occupantArray = new ArrayList<LinkedList>();
		for (int j = 0; j < rows; j++) {
			occupantArray.add(new LinkedList<SparseOccupants>());
		}
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
		ArrayList<Location> theLocations = new ArrayList<Location>();
		// Look at all grid locations.
		for (int r = 0; r < getNumRows(); r++) {
			// get the row linked list
			LinkedList<SparseOccupants> row = occupantArray.get(r);
			if (row != null) {
				for (SparseOccupants occ : row) // traverse the row
				{
					Location loc = new Location(r, occ.getColNum());
					theLocations.add(loc);
				}
			}
		}
		return theLocations;
	}

	public E get(Location loc) {
		if (!isValid(loc))
			throw new IllegalArgumentException("Location " + loc + " is not valid");

		LinkedList<SparseOccupants> row = occupantArray.get(loc.getRow());
		// get the row

		if (row != null) // traverse to find the item at location loc
		{
			for (SparseOccupants occ : row) {
				if (loc.getCol() == occ.getColNum()) {
					return (E) occ.getOccupant(); // must cast to E
				}
			}
		}
		return null;
	}

	public E put(Location loc, E obj) {
		if (!isValid(loc))
			throw new IllegalArgumentException("Location " + loc + " is not valid");
		if (obj == null)
			throw new NullPointerException("obj == null");
		// Remove the old occupant from the grid, if there is one.
		E oldOccupant = remove(loc);

		// Add the object to the grid.
		occupantArray.get(loc.getRow()).add(new SparseOccupants(obj, loc.getCol()));

		return oldOccupant;
	}

	public E remove(Location loc) {
		if (!isValid(loc))
			throw new IllegalArgumentException("Location " + loc + " is not valid");

		// Remove the object from the grid.
		E obj = get(loc);

		if (obj == null)
			return null; // if not found, return null

		LinkedList<SparseOccupants> row = occupantArray.get(loc.getRow());

		if (row != null) {
			Iterator<SparseOccupants> itr = row.iterator();
			while (itr.hasNext()) {
				if (itr.next().getColNum() == loc.getCol()) {
					itr.remove();
					break;
				}
			}
		}
		return obj;
	}
}