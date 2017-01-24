import java.util.ArrayList;

import apcslib.Format;
import chn.util.*;

public class Store {
	  private static Item[] myStore = new Item[50];
	  
	  public Store(String fileName) { 
		 FileInput in = new FileInput(fileName);
		 int i = 0;
		 while(in.hasMoreLines()) {
			 int id = 0;
			 int inv = 0;
			 id = in.readInt();
			 inv = in.readInt();
			 myStore[i] = new Item(id, inv);
			 i++;
		 }
	  }
	  public void displayStore() {
		  
		  System.out.println((Format.left("id", 15)+"inv"));
		  System.out.println();
		  for (int i = 0; i < 50; i++){
				 System.out.println(myStore[i]);
		  }
	  }
	  public void doSort(){
		  quickSort(myStore, 0, myStore.length - 1);
	  }
	  
	  private void quickSort(Item[] list, int first, int last) {
		  	int i = first;
	        int j = last;
	        Item index = list[first + (last - first) / 2];
	        while (i <= j)
	        {
	         
	            while (list[i].compareTo(index) < 0)
	            {
	                i++;
	            }
	            while (list[j].compareTo(index) > 0)
	            {
	                j--;
	            }
	            if (i <= j)
	            {
	                Item temp = list[j];
	                list[j] = list[i];
	                list[i] = temp;
	                i++;
	                j--;
	            }
	        }
	        if (first < j) {
	            quickSort(list, first, j);
	        }
	        if (i < last) {
	            quickSort(list, i, last);
	        }
	  }
	  public void testSearch()
	    {
	        int idToFind;
	        int index;
	        ConsoleIO console = new ConsoleIO();
	 
	        System.out.println("Testing search algorithm\n");
	        System.out.print("Enter Id value to search for (-1 to quit) ---> ");
	        idToFind = console.readInt();
	        while (idToFind >= 0)
	        {
	            index = binarySearch(new Item(idToFind, 0));
	            System.out.print("Iterative binary search: Id # " + idToFind);
	            if (index == -1) {
	                System.out.println("     No such part in stock");
	            }
	            else {
	                System.out.println("     Inventory = " + myStore[index].getInv());
	            }
	            index = binarySearch(new Item(idToFind, 0), 0, myStore.length - 1);
	            System.out.print("Recursive binary search: Id # " + idToFind);
	            if (index == -1) {
	                System.out.println("     No such part in stock");
	            }
	            else{
	                System.out.println("     Inventory = " + myStore[index].getInv());
	            }
	            System.out.print("\nEnter Id value to search for (-1 to quit) ---> ");
	            idToFind = console.readInt();
	        }
	    }
	
	    int binarySearch(Item idToSearch)
	    {
	        int low = 0;
	        int high = myStore.length - 1;
	 
	        while (high >= low)
	        {
	            int middle = (low + high) / 2;
	            int compare = myStore[middle].compareTo(idToSearch);
	            if (compare == 0)
	            {
	                return middle;
	            }
	            if (compare < 0)
	            {
	                low = middle + 1;
	            }
	            if (compare > 0)
	            {
	                high = middle - 1;
	            }
	        }
	        return -1;
	    }
	    int binarySearch(Item idToSearch, int first, int last)
	    {
	        if (first > last) {
	            return -1;
	        }
	        int middle = (first + last)/2;
	        int compare = myStore[middle].compareTo(idToSearch);
	        if (compare == 0) {
	            return middle;
	        }
	        if (compare < 0) {
	             return binarySearch(idToSearch, middle + 1, last);
	        }
	        if (compare > 0) {
	             return binarySearch(idToSearch, first, middle - 1);
	        }
	        return -1;
	    }
	
	  public static void main(String[] args) {
		    Store miniMart = new Store("/Users/tusharchopra/Desktop/Untitled.txt");
			System.out.println("Database before sorted: ");
			System.out.println();
			miniMart.displayStore();
			miniMart.doSort();
			System.out.println();
			System.out.println("Database after sorted by id: ");
			System.out.println();
			miniMart.displayStore();
			
			miniMart.testSearch();
		  
	  }
}
