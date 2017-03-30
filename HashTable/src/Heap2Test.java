import chn.util.*;
 
public class Heap2Test
{
    Heap2<Item> myHeap;

    public Heap2Test(String fileName){
        myHeap = new Heap2<Item>();
        loadFile(fileName);
    }
 
    private void loadFile(String fileName){
        int id, inv;
        FileInput inFile = new FileInput(fileName);
 
        int howMany = inFile.readInt();
        for (int k = 1; k <= howMany; k++){
            id = inFile.readInt();
            inv = inFile.readInt();
            myHeap.add(new Item(id, inv));
        }
    }
 
    public void sort(){
        while (!myHeap.isEmpty()){
            System.out.println(myHeap.removeMin());
        }
    }
    
    public static void main(String[] args){
        Heap2Test heapTest = new Heap2Test("/Users/tusharchopra/Desktop/file20.txt");
        heapTest.sort();
    }
}