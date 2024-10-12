import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		Queue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			queue.add(Integer.parseInt(in.readLine()));
		}

		int total = 0;
		while (queue.size() > 1) {
			int first = queue.poll();
			int second = queue.poll();
			
			int sum = first + second;
			total += sum;
			queue.add(sum);
		}
		System.out.println(total);
	}
}