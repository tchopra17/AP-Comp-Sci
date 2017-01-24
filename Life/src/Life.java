import chn.util.*;
import apcslib.*;
public class Life
{
    private boolean[][] cells = new boolean[20][20];
    private int population = 0;
    public static void main(String [] args)
    {
        Life life = new Life();
        life.readFile("/Users/tusharchopra/Desktop/Text.txt");
        int generation = 5;
        life.generation(generation);
        System.out.println("Organisms in row 10 = " + life.getRAlive(10-1));
        System.out.println("Organisms in column 10 = " + life.getCAlive(10-1));
        System.out.println("Total organisms alive = " + life.getTotAlive());
    }
    
    public void readFile(String fileName)
    {
    	FileInput infile = new FileInput(fileName);
		while (infile.hasMoreLines()) {
			int first = 0;
			int second = 0;
			first = infile.readInt() - 1;
			second = infile.readInt() - 1;
			cells[first][second] = true;
		}
    }
    
  
    public boolean neighbors(int row, int column)
    {
        int neighbors = 0;
        for(int i = row - 1 ; i <= row + 1 ; i++)
        {
            for(int j = column - 1; j <= column + 1 ; j++)
            {
            	//
                if(!( i == row && j == column) && !( i < 0 || j < 0 ) && 
                !(i>= cells.length || j >= cells[0].length))
                {
                    if(cells[i][j] == true)
                    {
                        neighbors++;
                    }
                }
            }
        }
        if(neighbors == 0 || neighbors == 1 || neighbors >= 4)
        {
            return false;
        }
        else if(neighbors == 2)
        {
            return cells[row][column];
        }
        else
        {
            return true;
        }
    }
    
    public void generation(int generation)
    {
        System.out.println("Generation 0: ");
        System.out.println();
        printOut();
        for(int i = 0; i < generation ; i++)
        {
            System.out.println("Generation " + (i+1) + ":");
            System.out.println();
            boolean [][] scratch = new boolean [cells.length][cells[0].length];
            for(int j = 0; j < cells.length; j++)
            {
                for(int k = 0; k < cells[j].length; k++)
                {
                    scratch[j][k] = neighbors(j, k); 
                }
            }
            cells = scratch;
            printOut();
            System.out.println();
        }
    }
    public int getCAlive(int column)
    {
        int total = 0;
        for(int i = 0; i < cells.length; i++)
        {
            if(cells[i][column] == true)
            {
                total++;
            }
        }
        return total;
    }
    
    public int getRAlive(int row)
    {
        int total = 0;
        for(int i = 0; i < cells[row].length ; i++)
        {
            if(cells[row][i] == true)
            {
                total++;
            }
        }
        return total;
    }
    
    public int getTotAlive()
    {
        int total = 0;
        for(int i = 0; i < cells.length; i++)
        {
            for(int j = 0; j < cells[i].length; j++)
            {
                if(cells[i][j] == true)
                {
                    total++;
                }
            }
        }
        return total;
    }
    public void printOut()
    {
        System.out.println("       12345678901234567890");
        System.out.println();
        for(int i = 0; i < cells.length ; i++)
        {
            System.out.print(Format.left(( i + 1 ), 0) + "     ");
            for(int j = 0; j < cells[0].length ; j++)
            {
                if( cells[i][j] == true )
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
