import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}

		while (queue.size() != 1) {
			for (int i = 0; i < K - 1; i++) {
				int value = queue.poll();
				queue.offer(value);
			}
			sb.append(queue.poll() + ", ");

		}
		sb.append(queue.poll()).append(">");
		System.out.println(sb);

	}

}