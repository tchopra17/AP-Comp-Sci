import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import apcslib.*;
import chn.util.*;

public class SAM2
{
    public void testFind(TreeMap list)
    {
        int idToFind;
       
        ConsoleIO console = new ConsoleIO();

        System.out.println("Testing search algorithm\n");
        System.out.print("Enter Id value to search for (-1 to quit) --> ");
        idToFind = console.readInt();
        
        
        while (idToFind != -1)
        {
        	if (list.get(idToFind) == null){
        		System.out.println("Id = " + idToFind + "  No such part in stock");
            } else {
            	System.out.println("It is in the list");
            }
            System.out.println();
            System.out.print("Enter Id value to search for (-1 to quit) --> ");
            idToFind = console.readInt();
        }
    }
    public void testPrint(TreeMap list){
    	Set<Integer> set = list.keySet();
    	Iterator<Integer> iter = set.iterator();
    	
    	while (iter.hasNext()){
    		System.out.println(list.get(iter.next()));
    	}
    			
    }
    public void testDelete(TreeMap list)
    {
        int idToDelete;
       
        ConsoleIO console = new ConsoleIO();

        System.out.println("Testing deletion\n");
        System.out.print("Enter Id value to delete (-1 to quit) --> ");
        idToDelete = console.readInt();
        
        
        while (idToDelete != -1)
        {
        	if (list.get(idToDelete) == null){
        		System.out.println("Id = " + idToDelete + "  No such part in stock");
            } else {
            	list.remove(idToDelete);
            	System.out.println(idToDelete + " removed.");
            }
            System.out.println();
            System.out.print("Enter Id value to search for (-1 to quit) --> ");
            idToDelete = console.readInt();
        }
    }

  

    public void readData(TreeMap list)
    {
        FileInput inFile;

        String fileName = "/Users/tusharchopra/Desktop/file20.txt";
        int id, inv;

        inFile = new FileInput(fileName);

        int howMany = inFile.readInt();
        for (int k = 1; k <= howMany; k++)
        {
            id = inFile.readInt();
            inv = inFile.readInt();
            list.put(id, new Item(id, inv));
        }
    }

    public void mainMenu (TreeMap list)
    {
        String choice;
        ConsoleIO console = new ConsoleIO();

        do
        {
            System.out.println("TreeMap\n");
            System.out.println("(1) Read data from disk");
            System.out.println("(2) Print ordered tree");
            System.out.println("(3) Search tree");
            System.out.println("(4) Count nodes in tree");
            System.out.println("(5) Delete nodes in tree");
            System.out.println("(Q) Quit\n");
            System.out.print("Choice ---> ");
            choice = console.readLine() + " ";

            System.out.println();

            if ('1' <= choice.charAt(0) && choice.charAt(0) <= '7')
            {
                switch (choice.charAt(0))
                {
                    case '1' :
                    readData(list);
                    break;
                    case '2' :
                    System.out.println();
                    System.out.println("The tree printed");
                    testPrint(list);
                    System.out.println();
                    break;
                    case '3' :
                    testFind(list);
                    break;
                    case '4' :
                    System.out.println("Number of nodes = " + list.size());
                    System.out.println();
                    break;        
                    case '5' :
                    testDelete(list);
                    break;
                }
            }
        }
        while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
    }

    public static void main(String[] args)
    {
        TreeMap list = new TreeMap();
        SAM2 test = new SAM2();
        test.mainMenu(list);
    }
}