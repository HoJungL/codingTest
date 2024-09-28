import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	private static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	private static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if (rootA == rootB) {
			return false;
		}
		parents[rootB] = rootA;
		return true;
	}

	private static class Edge implements Comparable<Edge>{
		public int start;
		public int end;
		public int weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	// 정점, 간선 개수
	private static int V, E;
	private static Edge[] edgeList;

	private static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		V = Integer.parseInt(split[0]);
		E = Integer.parseInt(split[1]);
		edgeList = new Edge[E];

		int from, to, weight;

		for (int i = 0; i < E; i++) {
			split = in.readLine().split(" ");
			from = Integer.parseInt(split[0])-1;
			to = Integer.parseInt(split[1])-1 ;
			weight = Integer.parseInt(split[2]);

			edgeList[i] = new Edge(from, to, weight);
		}

		Arrays.sort(edgeList);
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}

		// 간선 개수 담을
		int result = 0;
		// 최소 비용 담을
		int cost = 0;
		for (Edge edge : edgeList) {
			if (union(edge.start, edge.end)) {
				cost += edge.weight;
				result++;
				if (result == V - 1) {
					break;
				}
			}
		}
		System.out.println(cost);

	}

}