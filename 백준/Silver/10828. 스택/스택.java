import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0 ; i<N; i++) {
			String[] split = in.readLine().split(" ");
			
			if (split[0].equals("push")) {
				stack.add(Integer.parseInt(split[1]));
			}else if (split[0].equals("pop")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(stack.pop());
				}
			}
			else if (split[0].equals("size")) {
				System.out.println(stack.size());
			}
			else if (split[0].equals("empty")) {
				if (stack.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else {
				if(stack.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack.peek());
				}
			}
		}
	}

}