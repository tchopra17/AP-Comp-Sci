import apcslib.*;
import chn.util.*;

public class TreeTest{

    public void readData(BSTree list){
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

    public void mainMenu (BSTree<String> head){
        String choice;
        ConsoleIO console = new ConsoleIO();

        do{
            System.out.println("Linked List algorithm menu");
            System.out.println("(1) Fill the tree from a file");
            System.out.println("(2) Preorder output");
            System.out.println("(3) Inorder output");
            System.out.println("(4) Postorder output");
            System.out.println("(5) Count nodes in tree");
            System.out.println("(6) Count leaves in tree");
            System.out.println("(7) Find the height of the tree");
            System.out.println("(8) Find the width of the tree");
            System.out.println("(9) Clear Tree");
            System.out.println("(Q) Quit\n");
            System.out.print("Choice ---> ");
            choice = console.readLine() + " "; 

            System.out.println();

            if ('1' <= choice.charAt(0) && choice.charAt(0) <= '9')
            {
                switch (choice.charAt(0))
                {
                    case '1' :
                    readData(head);
                    break;
                    case '2' :
                    System.out.println();
                    System.out.println("The tree printed preorder");
                    head.inorder();
                    System.out.println();
                    break;
                    case '3' :
                    System.out.println();
                    System.out.println("The tree printed inorder");
                    head.inorderNoRecur();
                    System.out.println();
                    break;
                    case '4' :
                    System.out.println();
                    System.out.println("The tree printed postorder");
                    head.postorder();
                    System.out.println();
                    break;
                    case '5' :
                    System.out.println("Number of nodes = " + head.nodesize());
                    System.out.println();
                    break;
                    case '6' :
                    System.out.println("Number of leaves = " + head.leafsize());
                    System.out.println();
                    break;
                    case '7' :
                    System.out.println("The height is = " + head.findheight());
                    System.out.println();
                    break;
                    case '8' :
                    System.out.println("The width is = " + head.findwidth());
                    System.out.println();
                    break;
                    case '9' :
                    System.out.println("Tree Cleared.");
                    head.clear();
                    System.out.println();
                }
            }
        }
        while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
    }

    public static void main(String[] args)
    {
        BSTree<String> list = new BSTree<String>();
        TreeNode<String> node = new TreeNode<String>(null,null,null);
        TreeTest test = new TreeTest();
        test.mainMenu(list);
    }
}