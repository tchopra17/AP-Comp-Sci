import java.util.*;
public class HashTable<E> {

	LinkedList<E>[] table;
	
	public HashTable(int size){
		table = new LinkedList[(int)(size*1.5)];
	}

	public void insert(E object){
		
		int hshCode = object.hashCode()%table.length;
		if(table[hshCode] == null){
			table[hshCode] = new LinkedList<E>();
		}
		
		ListIterator<E> iter = table[hshCode].listIterator();
		while (iter.hasNext()){
			iter.next();
		}
		iter.add(object);
	}
	
	public E find(E findValue){
		int hshCode = findValue.hashCode()%table.length;
		if(table[hshCode] == null){
			table[hshCode] = new LinkedList<E>();
		}
		ListIterator<E> iter = table[hshCode].listIterator();
		while (iter.hasNext())
		{
			E temp = iter.next();
			if (findValue.equals(temp))
			{
				return temp;
			}
		}	
		return null;
	}
	
	public double empty(){
		int empty = 0;
		for (int i = 0; i < table.length; i++){
			if (table[i] == null){
				empty++;
			}
		}
		return ((empty+ 0.)/table.length)*100;
	}
	public double averageLength(){
		int used = 0;
		int sum = 0;
		for (int i = 0; i < table.length; i++){
			if (table[i] != null){
				used++;
				sum += count(table[i]);
			}
		}
		return ((double)sum)/used;
	}
	
	public int getLongestLength(){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < table.length; i++){
			if (table[i] != null){
				max = Integer.max(max, count(table[i]));
			}
		}
		return max;
	}
	public int count(LinkedList<E> list){
		int count = 0;
		ListIterator<E> iter = list.listIterator();
		while (iter.hasNext())
		{
			count++;
			iter.next();
		}
		return count;
	}
}
