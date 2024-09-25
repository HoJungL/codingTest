import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static class Node {
		public int start;
		public int end;
		public int weight;

		public Node(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int D = Integer.parseInt(split[1]);

		// 도로 최단거리 배열
		int[] distances = new int[D + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[0] = 0;

		// 지름길 저장
		Node[] nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);
			int len = Integer.parseInt(split[2]);

			nodes[i] = new Node(from, to, len);
		}

		// 거리 계산
		for (int i = 0; i < D; i++) {
			distances[i + 1] = Math.min(distances[i + 1], distances[i] + 1);

			// 지름길 확인
			for (Node node : nodes) {
				if (node.start == i && node.end <= D) {
					// 지름길이나 가셈.
					distances[node.end] = Math.min(distances[node.end], distances[i] + node.weight);
				}
			}
		}

		System.out.println(distances[D]);

	}

}