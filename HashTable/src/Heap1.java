import chn.util.FileInput;
import java.util.*;

public class Heap1 {

	public static void main(String[] args) {
		PriorityQueue<Item> queue = readData("/Users/tusharchopra/Desktop/file20.txt");
		
		while (!queue.isEmpty()){
			System.out.println(queue.peek());
			queue.remove();
		}
	}
	public static  PriorityQueue<Item> readData(String fileName){
		PriorityQueue<Item> queue = new PriorityQueue<Item>();
		FileInput in = new FileInput(fileName);
		int i = in.readInt();
		while(in.hasMoreLines()) {
			 int id = 0;
			 int inv = 0;
			 id = in.readInt();
			 inv = in.readInt();
			 queue.add(new Item(id, inv));
		 }
		 return queue;
	}

}
