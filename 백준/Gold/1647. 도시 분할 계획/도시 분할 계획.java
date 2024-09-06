import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	// 1. findSet
	static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	// 2. union
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}

	// 3. Edge
	static class Edge implements Comparable<Edge> {
		public int from;
		public int to;
		public int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	static int[] parents;
	static int V;
	static int E;
	static Edge[] edgeList;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] st = in.readLine().split(" ");
		V = Integer.parseInt(st[0]);
		E = Integer.parseInt(st[1]);
		edgeList = new Edge[E];
		int from, to, weight;
		for (int i = 0; i < E; i++) {
			st = in.readLine().split(" ");
			from = Integer.parseInt(st[0])-1;
			to = Integer.parseInt(st[1]) -1;
			weight = Integer.parseInt(st[2]);
			edgeList[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edgeList);

		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}

		int result = 0;
		int max = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				cnt++;
				if (cnt ==V-1) {
					max = edge.weight;
					break;
				}

			}
		}
		System.out.println(result- max);

	}

}