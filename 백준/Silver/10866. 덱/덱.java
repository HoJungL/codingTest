import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");

			if (split[0].equals("push_front")) {
				queue.addFirst(Integer.parseInt(split[1]));
			} else if (split[0].equals("push_back")) {
				queue.addLast(Integer.parseInt(split[1]));
			} else if (split[0].equals("pop_front")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.removeFirst());
				}

			} else if (split[0].equals("pop_back")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.removeLast());
				}
			} else if (split[0].equals("size")) {
				System.out.println(queue.size());
			} else if (split[0].equals("empty")) {
				if (queue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (split[0].equals("empty")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.removeFirst());
				}
			} else if (split[0].equals("front")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.peekFirst());
				}
			} else if (split[0].equals("back")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.peekLast());
				}
			} else {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.removeLast());
				}
			}
		}

	}
}