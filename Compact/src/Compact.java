// Tushar Chopra

import chn.util.*;

import java.util.Arrays;

import apcslib.*;

public class Compact {
	
	
	public static void main(String[] args) {
		int[] data = new int[20];
		int position = 0;
		int newLogSize = data.length;
		
		FileInput input = new FileInput("/Users/tusharchopra/Desktop/text.txt");
		while (input.hasMoreTokens()) {
			data[position] = input.readInt();
			position++;
		}
		System.out.println("Before: ");
		printList(data, newLogSize);
		newLogSize = remover(data);
		System.out.println();
		System.out.println("After: ");
		printList(data, newLogSize);
	}
	
	public static int remover(int[] data) {		
		int logSize = data.length;
		 for (int i = 0; i < data.length; i++) {
			if (data[i] == 0) {
				for (int x = i; x < data.length - 1; x++) {
					data[x] = data[x + 1];
				}
			}
		}
		 
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 0) {
				logSize--;
				for (int x = i; x < data.length - 1; x++) {
					data[x] = data[x + 1];
				}
			}
		}
		
		return logSize;
	}

	public static void printList(int[] data, int logSize) {
		for (int i = 0; i < logSize; i++) {
			System.out.print(data[i] + " ");
		}
	}
}





