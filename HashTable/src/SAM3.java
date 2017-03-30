import java.util.*;

import chn.util.ConsoleIO;

public class SAM3{
	public static void main(String[] args){
		Set<Integer> treeset = new TreeSet<Integer>();
		Set<Integer> hashSet = new HashSet<Integer>();
		SAM3 test = new SAM3();
		test.mainMenu(treeset, hashSet);
	}
	public void populate(Set<Integer> set, int maxValue){
		for(int loop = 2; loop <= maxValue; loop++){
			set.add(loop);
		}
	}
	public void SOE(Set<Integer> set, int maxValue){
		for(int loop=2; loop<=Math.sqrt(maxValue); loop++){
			for(int loop2 = 2*loop; loop2 <= maxValue; loop2 += loop){
				set.remove(loop2);
			}
		}
	}
	public void print(Set<Integer> set){
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	public void mainMenu (Set<Integer> set1, Set<Integer> set2){
        String choice;
        ConsoleIO console = new ConsoleIO();
        int maxValue = 0;
        long num1, num2, total;
        while(maxValue >= 0){
        	System.out.print("Enter the max number ---> ");
        	maxValue = console.readInt();
        	do{	
        		System.out.println("(1) HashSet");
        		System.out.println("(2) TreeSet");
        		System.out.println("(Q) Quit\n");
        		System.out.print("Choice ---> ");
        		choice = console.readLine() + " ";

        		System.out.println();

        		if ('1' <= choice.charAt(0) && choice.charAt(0) <= '7'){
        			switch (choice.charAt(0)){
        				case '1' :
        					num1 = System.currentTimeMillis();
        					populate(set2, maxValue);
        					SOE(set2, maxValue);
        					num2 = System.currentTimeMillis();
	                    	total = num2 - num1;
	                    	print(set2);
	                    	System.out.println("The amount of time taken: " + total);
	                    break;
	                    case '2' :
	                    	num1=System.currentTimeMillis();
	                    	populate(set1, maxValue);
	                    	SOE(set1, maxValue);
	                    	num2 = System.currentTimeMillis();
	                    	total = num2 - num1;
	                    	print(set1);
	                    	System.out.println("The amount of time taken: " + total);
	                    break;
        			}
        		}
        	}
        	while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
        		set1.clear();
            	set2.clear();
        	}
        }
	}
