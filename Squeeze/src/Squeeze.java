// Tushar Chopra

import chn.util.*;
import apcslib.*;

public class Squeeze {
	public static void main(String[] args) {
		FileInput inFile = new FileInput("/Users/tusharchopra/Desktop/Tushar/Development/APCS/Squeeze/src/Squeeze.java");
		FileOutput outFile = new FileOutput("/Users/tusharchopra/Desktop/Squeeze.txt"); 
		while (inFile.hasMoreLines()) {
			int spaces = 0;
			boolean isLetter = false;
			int i = 0;
			String line = inFile.readLine();
			while (!isLetter && i < line.length()) {
				if (line.charAt(i) == '\t') {
					spaces++;
				} else {
					isLetter = true;
				}
				i++;
			}
			String newline = line.trim();
			System.out.println(spaces + " " + newline);
			outFile.println(spaces + " " + newline);
		}
		outFile.close();
	}
}
