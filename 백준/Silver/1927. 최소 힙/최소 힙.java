import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new PriorityQueue<>();
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(in.readLine());
			if (input == 0 && queue.isEmpty()) {
				System.out.println(0);
			} else if (input == 0 && !queue.isEmpty()) {
				System.out.println(queue.poll());
			}
			if (input != 0) {
				queue.add(input);
			}
		}
	}

}