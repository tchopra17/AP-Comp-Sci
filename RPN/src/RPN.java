import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import chn.util.*;

public class RPN {
	public static void main(String[] args) throws Exception {
		
		System.out.println("Please enter your mathematical function, = to solve:");
		
		String input;
		ConsoleIO in = new ConsoleIO();
		Queue<String> queue = new LinkedList<String>();
		Stack<Integer> stack = new Stack<Integer>();
		
		while (true) {
			do {
				input = in.readToken();
				if (!input.equals("=")) {
					queue.add(input);
				}
				if (!input.equals("+") && !input.equals("-") && !input.equals("*") && !input.equals("/")&& !input.toLowerCase().equals("=")) {
					stack.push(Integer.parseInt(input));
				} else if (!input.toLowerCase().equals("=")) {
					int y = stack.pop();
					int x = stack.pop();
					if (input.equals("+")) {
						x += y;

					} else if (input.equals("-")) {
						x -= y;
					} else if (input.equals("*")) {
						x *= y;
					} else if (input.equals("/")) {
						x /= y;
					}
					stack.push(x);
				}
			} while (!input.equals("="));

			while (queue.isEmpty() == false) {

				System.out.print(queue.remove() + " ");
			}
			System.out.print("= " + stack.pop());
		}
	}
	
    /*private static int calc(Stack<String> stack){
        String temp = stack.pop();
        int x, y;
        try{
            y = Integer.parseInt(temp);
        }
        catch (Exception e){
            x = calc(stack);
            y = calc(stack);
            if (temp.equals("+")){
                y += x;
            }
            else if (temp.equals("-")){
                y -= x;
            }
            else if (temp.equals("*")){
                y *= x;
            }
            else if (temp.equals("/")){
                y /= x;
            }
        }
        return y;
    }
    */
}