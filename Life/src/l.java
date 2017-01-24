//Tushar Chopra

import java.util.ArrayList;
import java.util.Arrays;
import apcslib.Format;
import chn.util.*;

public class Life {
	private static boolean[][] cells = new boolean[22][22];
	private static boolean[][] newGameBoard = new boolean[22][22];
	private static boolean[][] finalGameBoard = new boolean[22][22];
	public static void main(String[] args){
		life(5,"/Users/tusharchopra/Desktop/Text.txt");  
	}
	public static void input(String inputFileName){
		FileInput infile = new FileInput(inputFileName);
		while (infile.hasMoreLines()) {
			int first = 0;
			int second = 0;
			first = infile.readInt() - 1;
			second = infile.readInt() - 1;
			cells[first][second] = true;
		}
	}

	public static int neighbors(boolean[][] cells, int x, int y) {
		int neighbors = 0;
		
			if (cells[x - 1][y - 1]) {
				neighbors++;
			}
			if (cells[x - 1][y + 1]) {
				neighbors++;
			}
		if (cells[x + 1][y - 1]) {
			neighbors++; 
		}
		if (cells[x + 1][y + 1]) {
			neighbors++;
		}
		if (cells[x][y - 1]) {
			neighbors++;
		}
		if (cells[x][y + 1]) {
			neighbors++;
		}
		if (cells[x + 1][y]) {
			neighbors++;
		}
		if (cells[x - 1][y]) {
			neighbors++;
		}
		
		return neighbors;
	}

	public static void generation() {
		for (int i = 1; i < 19; i++) {
			for (int j = 1; j < 19; j++) {
				if (i == 1 && j == 7) {
					System.out.println("hit");
					System.out.println(neighbors(cells, i, j));
				}
				
			    int neighbors = neighbors(cells, i, j);
				
			    if(neighbors == 3 && cells[i][j] == false){//if cell is dead and neighbors = 3(made  for preventing 2+ neighbors)
					newGameBoard[i][j] = true;//make neighbors
				}
		
				else if(neighbors <= 1){//if 1- neighbors and neighbors cell
					newGameBoard[i][j] = false;//Any cell with one or zero neighbors will die of loneliness
				}
				else if(neighbors >= 4){//if 4+ neighbors and neighbors cell
					newGameBoard[i][j] = false;//any cell with four or more neighbors will die from overciding (a "death").
				}
				else if((neighbors == 2 || neighbors == 3) && (cells[i][j] == true)){//if 2-3 neighbors and neighbors cell
					newGameBoard[i][j] = true;//Any cell with two or three neighbors will live into the next generation (no change).
				}
			}
		}
		System.out.println(newGameBoard[1][7]);
	}

	public static void printBoard(boolean[][] cells) {
		System.out.println("       12345678901234567890");
		for (int i = 0; i < 20; i++) {
			System.out.print(i+1 + "      ");
			for (int j = 0; j < 20; j++) {
				if (cells[i][j] == true){
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void life(int numGenerations,String fileName){
		System.out.println("Generation 0: ");
		input(fileName);
		generation();
		printBoard(cells);
		printBoard(newGameBoard);
		cells = newGameBoard;
		
		
		for (int i = 0; i < 5; i++){
			System.out.println();
			System.out.println("Generation" + (i+1) + ": ");
			System.out.println();
		} 
	}
}