import java.util.*;

public class Heap2<E> {
	
	private List<E> items;
    private int mySize;
    
    public Heap2(){
        items = new ArrayList<E>();
        items.add(null);
        mySize = 0;
    }
    public void add(E obj){
        items.add(obj);
        mySize++;
        int k = mySize;
        boolean done = false;
        while (done == false && k > 1) {
            Comparable<E> parent = (Comparable<E>) items.get(k / 2);
            E child = items.get(k);
            E temp = items.get(k / 2);
            if (parent.compareTo(child) > 0){
                items.set(k, temp);
                items.set(k / 2, obj);
                k = k / 2;
            }
            else {
                done = true;
            }
        }
        items.set(k, obj);
    }
    public E removeMin(){
        E min;
        if (!items.isEmpty()){
            min = items.get(1);
            items.set(1, items.get(mySize));
            mySize--;
            if (mySize > 1){
                heapify(1);
            }
            return min;
        }
        return null;
    }
    public E peekMin(){
        if (!items.isEmpty()){
            return items.get(1);
        }
        return null;
    }
 
    public boolean isEmpty(){
        if (mySize == 0){
            return true;
        }
        return false;
    }
    private void heapify(int root){
        Comparable<E> last = (Comparable<E>)items.get(root);
        int k = root;
        while (2 * k <= mySize){
            int child = 2 * k;
            E left = items.get(child);
            Comparable<E> right = (Comparable<E>) items.get(child + 1);
            if (child < mySize){
                if (right.compareTo(left) < 0){
                    child++;
                }
            }
            if (last.compareTo(items.get(child)) <= 0){
                break;
            }
            else{
                items.set(k, items.get(child));
                k = child;
            }
        }
        items.set(k, (E) last);
    }
}
