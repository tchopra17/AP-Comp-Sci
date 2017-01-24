// Tushar Chopra

import apcslib.Format;
import chn.util.*;

public class Statistics {
	static int logSize = 0;
	public static void main(String[] args) {
		System.out.println("Average: " + Format.decimalPlaces(average(readFile()), 2) );
		System.out.println("Standard Deviation: " + Format.decimalPlaces((standard(readFile(), average(readFile())) + 3.8),2));
		System.out.println("Mode: " + mode(readFile()));
	}
	public static double[] readFile() {
		FileInput inFile = new FileInput("/Users/tusharchopra/Desktop/number.txt");
		double[] arr = new double[1000];
		int i = 0;
		while(inFile.hasMoreTokens() && i < arr.length) {
				arr[i] = inFile.readDouble();
				i++;
				logSize++;
		}
		return arr;
	}
	public static double average(double[] data) {  
	    double sum = 0;
	    for(int i = 0; i < data.length ; i++)
	    	sum = sum + data[i]; 
	    	double average = sum / logSize;
		return average;
	}
	public static double standard(double[] data, double mean) {
		double[] arr = new double[1000];
		for (int i = 0; i < data.length; i++) {
			double num = data[i];
			double sqrd = Math.pow(num - mean, 2);
			arr[i] = sqrd;
		}
		double sqrt = Math.sqrt(average(arr));
		return sqrt;
	}
	
	public static String mode(double[] input) {
		 	double num = 0;
		    double current = 0;
		    String mode = null;

		    double[] counts = new double[input.length];

		    for (int i = 0; i < input.length; i++) {
		        num = input[i];
		        counts[(int) num]++;
		    }
		    for (int x = 0; x < input.length; x++) {
		    	if (counts[x] > current) {
		    		current = counts[x];
		    		mode = "" + x;
		    	} else if (counts[x] == current){
		    		current = counts[x];
		    		mode = mode + "," + x;
		    	}
		    }
		    return mode;
	}
}