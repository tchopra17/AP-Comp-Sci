import apcslib.Format;

public class Item implements Comparable<Item>

{
  private int myId;
  private int myInv;
  
  public Item(int id, int inv)
  {
    myId = id;
    myInv = inv;
  }
  
  public int getId(){
	return myId; 
	  
  }
  public int getInv(){
	return myInv; 
  }
  public int compareTo(Item otherObject){
	return this.myId-otherObject.myId;
	  
  }
  public boolean equals(Item otherObject){
	return compareTo((Item)otherObject)==0;
	  
  }
  public String toString(){
	return (""+Format.left(myId, 15)+myInv);
	   
  }
}