
public class SparseBoundedGridNode {
	private Object occupant;
	private int col;
	private SparseBoundedGridNode next;
	public SparseBoundedGridNode(Object occ, int colNum,SparseBoundedGridNode initNext){
		occupant = occ;
	    col = colNum;
	    next = initNext;
	}
	public Object getOccupant(){
	    return occupant;
	}
	public int getColumn(){
		return col; 
	}
	public SparseBoundedGridNode getNext(){
	    return next;
	}
	public void setOccupant(Object occ){
	    occupant = occ;
	}
	public void setNext(SparseBoundedGridNode newNext){
	    next = newNext;
	}
}
