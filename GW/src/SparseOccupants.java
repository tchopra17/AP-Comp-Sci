public class SparseOccupants {
	private Object occupant;
	private int col;

	public SparseOccupants(Object occ, int colNum) {
		occupant = occ;
		col = colNum;
	}

	public Object getOccupant() {
		return occupant;
	}

	public int getColNum() {
		return col;
	}

	public void setOccupant(Object occ) {
		occupant = occ;
	}
}