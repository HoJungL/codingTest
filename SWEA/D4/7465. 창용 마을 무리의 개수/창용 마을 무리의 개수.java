import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	// findSet
	static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	// union
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}

	// edge
	static class Edge implements Comparable<Edge> {
		public int from;
		public int to;

		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.from - o.from;
		}

	}

	static int[] parents;
	static int T;
	static int V;
	static int E;
	static Edge[] edgeList;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			String[] st = in.readLine().split(" ");
			V = Integer.parseInt(st[0]);
			E = Integer.parseInt(st[1]);

			edgeList = new Edge[E];
			int from, to;
			for (int i = 0; i < E; i++) {
				st = in.readLine().split(" ");
				from = Integer.parseInt(st[0]) - 1;
				to = Integer.parseInt(st[1]) - 1;
				edgeList[i] = new Edge(from, to);
			}
			Arrays.sort(edgeList);

			parents = new int[V];
			for (int i = 0; i < V; i++) {
				parents[i] = i;
			}

			int cnt = 0;
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					cnt++;
					if (cnt == V - 1) {
						break;
					}
				}
			}
			int result = V-cnt;
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}