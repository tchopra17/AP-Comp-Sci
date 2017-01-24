// Tushar Chopra
import java.util.ArrayList;
public class Permutations {
	public static void main(String[] args) {
		permutate(10);
	}
	public static void permutate(int lines){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= lines; i++){
			System.out.print("List " + i + ": ");
			ArrayList<Integer> newList = new ArrayList<Integer>();
			int randMax = 10;
			for (int j = 1; j <= 10; j++) {
				newList.add(j);
			}
			for (int p = 0; p < 10; p++) {
				int rand = (int) (Math.random() * randMax);
				list.add(p, newList.get(rand));
				newList.remove(rand);
				randMax--;
				System.out.print(list.get(p) + " ");
			}
			int sum =  (list.get(0)) + (list.get(9));
			System.out.print(" Sum: " + sum);
			System.out.println();
		}
	}
}