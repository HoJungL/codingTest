import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

	private static int findSet(int a) {

		if (parents[a] == a) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}

	static class Edge implements Comparable<Edge> {

		public int from, to;
		double cost;

		public Edge(int from, int to, double cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.cost, o.cost);
		}

	}

	static long dist(int x1, int x2, int y1, int y2) {
		long dx = (long) (x2 - x1);
		long dy = (long) (y2 - y1);
		return dx * dx + dy * dy;
	}

	static int[] parents;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 테케 수
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			int N = Integer.parseInt(in.readLine());
			int[] x = new int[N];
			String[] st1 = in.readLine().split(" ");
			int[] y = new int[N];
			String[] st2 = in.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st1[i]);
				y[i] = Integer.parseInt(st2[i]);
			}
			double weight = Double.parseDouble(in.readLine());
			parents = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }
            ArrayList<Edge> edges = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					double cost = dist(x[i], x[j], y[i], y[j]) * weight;
					edges.add(new Edge(i,j,cost));
				}
			}
			Collections.sort(edges);
			double result = 0;
			int cnt = 0;
			for (Edge e : edges) {
				int xx = e.from;
				int yy = e.to;
				if (findSet(xx) != findSet(yy)) {
					union(xx, yy);
					result += e.cost;
					cnt++;
					if (cnt == N - 1) {
						break;
					}
				}
			}
			sb.append(Math.round(result)).append("\n");
		}
		System.out.println(sb);
	}

}