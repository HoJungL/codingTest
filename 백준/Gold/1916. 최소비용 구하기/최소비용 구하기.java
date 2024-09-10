import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static class Node {
		public int vertex;
		public Node link;
		public int weight;

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + ", weight=" + weight + "]";
		}

		public Node(int vertex, Node link, int weight) {
			super();
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}
	}

	static int V, E;
	static int max = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(in.readLine());
		E = Integer.parseInt(in.readLine());

		int from, to, weight;

		Node[] adjList = new Node[V+1];
		for (int i = 0; i < E; i++) {
			String[] split = in.readLine().split(" ");
			from = Integer.parseInt(split[0]);
			to = Integer.parseInt(split[1]);
			weight = Integer.parseInt(split[2]);

			adjList[from] = new Node(to, adjList[from], weight);
		}
		String[] split = in.readLine().split(" ");
		int start = Integer.parseInt(split[0]);
		int end = Integer.parseInt(split[1]);

		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Arrays.fill(distance, max);

		distance[start] = 0;
		int min = 0;
		int current = 0;
		for (int cnt = 0; cnt < V; cnt++) {
			current = -1;
			min = max;

			for (int i = 1; i <= V; i++) {
				if (!visited[i] && distance[i] < min) {
					min = distance[i];
					current = i;
				}
			}
			if (current == -1) {
				break;
			}
			visited[current] = true;
			// 가지치기

			if (current == end) {
				break;
			}

			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex] && distance[temp.vertex] > min + temp.weight) {
					distance[temp.vertex] = min + temp.weight;
				}
			}
		}
		System.out.println(distance[end] != max ? distance[end] : -1);

	}
}