
import chn.util.*;
 
public class HashTest{
    public static void main(String[] args){
    	HashTest test = new HashTest();
        HashTable<Item> list = new HashTable<Item>(400);
        test.mainMenu (list);
        test.stats(list);
    }
    
   
    public static void search(HashTable<Item> table)
    {
    	 int idToFind;
    	    Item location;

    	    ConsoleIO console = new ConsoleIO();

    	    System.out.println("Testing search algorithm\n");
    	    System.out.print("Enter Id value to search for (-1 to quit) --> ");
    	    idToFind = console.readInt();

    	    while (idToFind >= 0)
    	    {
    	      location = table.find(new Item(idToFind, 0));
    	      if (location == null){
    	        System.out.println("Id = " + idToFind + "  No such part in stock");
    	      }else{
    	        System.out.println(location);
    	      }
    	      System.out.println();
    	      System.out.print("Enter Id value to search for (-1 to quit) --> ");
    	      idToFind = console.readInt();
    	    }
    }
   
    public void mainMenu (HashTable<Item> head){
      String choice;
      ConsoleIO console = new ConsoleIO();

      do
      {
        System.out.println("Linked List algorithm menu\n");
        System.out.println("(1) Read data from disk");
        System.out.println("(2) Search list");
        System.out.println("(Q) Quit\n");
        System.out.print("Choice ---> ");
        choice = console.readLine() + " ";
        System.out.println();

        if ('1' <= choice.charAt(0) && choice.charAt(0) <= '2')
        {
          switch (choice.charAt(0))
          {
            case '1' :
              loadFile(head);
              break;
            case '2' :
              search(head);
              break;
          }
        }
      }
      while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
    }
    public void stats(HashTable<Item> table)
    {
    	 System.out.println("Percent empty: " + table.empty() + "\nAverage Length: " + table.averageLength() + "\nLongest Length: " + table.getLongestLength());
    }

    public static void loadFile(HashTable<Item> table)
    {
        FileInput inFile;
 
        String fileName = "/Users/tusharchopra/Desktop/file400.txt";
        int id, inv;
 
        inFile = new FileInput(fileName);
 
        int howMany = inFile.readInt();
        for (int k = 1; k <= howMany; k++)
        {
            id = inFile.readInt();
            inv = inFile.readInt();
            table.insert(new Item(id, inv));
        }
    }
}