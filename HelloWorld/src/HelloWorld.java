
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println(answer(5));
	}
    static int answer(int n)
	{
	if (1 == n)  return 2;
	else return  2 * answer (n - 1);
	}

}
