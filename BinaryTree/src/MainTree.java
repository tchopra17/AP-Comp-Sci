import apcslib.*;
import chn.util.*;

public class MainTree
{
    void testFind(BSTree<Item> list)
    {
        int idToFind;
        Item location;
        
        ConsoleIO console = new ConsoleIO();

        System.out.println("Testing search algorithm\n");
        System.out.print("Enter Id value to search for (-1 to quit) --> ");
        idToFind = console.readInt();

        while (idToFind >= 0)
        {
            location = list.find(new Item(idToFind, 0), list.getRoot());
            if (location == null)
                System.out.println("Id = " + idToFind + "  No such part in stock");
            else
                System.out.println(location);
            System.out.println();
            System.out.print("Enter Id value to search for (-1 to quit) --> ");
            idToFind = console.readInt();
        }
    }

  

    public void readData(BSTree<Item> list)
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
            list.insert(new Item(id, inv));
        }
    }

    public void mainMenu (BSTree<Item> head)
    {
        String choice;
        ConsoleIO console = new ConsoleIO();

        do
        {
            System.out.println("Linked List algorithm menu\n");
            System.out.println("(1) Read data from disk");
            System.out.println("(2) Print ordered tree");
            System.out.println("(3) Search tree");
            System.out.println("(4) Count nodes in tree");
            System.out.println("(Q) Quit\n");
            System.out.print("Choice ---> ");
            choice = console.readLine() + " ";

            System.out.println();

            if ('1' <= choice.charAt(0) && choice.charAt(0) <= '7')
            {
                switch (choice.charAt(0))
                {
                    case '1' :
                    readData(head);
                    break;
                    case '2' :
                    System.out.println();
                    System.out.println("The tree printed inorder\n");
                    head.inorder();
                    System.out.println();
                    break;
                    case '3' :
                    testFind(head);
                    break;
                    case '4' :
                    System.out.println("Number of nodes = " + head.size());
                    System.out.println();
                    break;        
                }
            }
        }
        while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
    }

    public static void main(String[] args)
    {
        BSTree<Item> list = new BSTree<Item>();
        TreeNode<Item> node = new TreeNode<Item>(null,null,null);
        MainTree test = new MainTree();
        test.mainMenu(list);
    }
}