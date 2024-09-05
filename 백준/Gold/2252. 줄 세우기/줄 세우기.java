import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static class Node {
		public int vertex;
		public Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

	}

	private static int V, E;
	private static Node[] adjList;
	private static int[] inDegree;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new Node[V + 1];
		inDegree = new int[V + 1];

		int from, to;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}

		List<Integer> list = topologySort();
		if (list.size() == V) {
			for (Integer vertex : list) {
				sb.append(vertex + " ");
			}
		}
		System.out.println(sb);
	}

	private static List<Integer> topologySort() {
		List<Integer> orderList = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= V; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			orderList.add(current);

			for (Node temp = adjList[current]; temp != null; temp = temp.link) {

				if (--inDegree[temp.vertex] == 0) {
					queue.add(temp.vertex);
				}
			}
		}

		return orderList;
	}

}