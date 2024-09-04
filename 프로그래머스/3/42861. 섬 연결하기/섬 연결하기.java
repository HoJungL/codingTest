import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public static class Edge {
		int from, to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

	}

	public static Edge[] edges;
	public static Map<Integer, Integer> roots;

	public int solution(int n, int[][] costs) {
		int k = costs.length;
		edges = new Edge[k];
		roots = new HashMap<>();

		for (int i = 0; i < n; i++)
			roots.put(i, i);

		for (int i = 0; i < k; i++)
			edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);

		Arrays.sort(edges, (o1, o2) -> o1.weight - o2.weight);

        // 크루스칼
		int cnt = 0;
		int totalCost = 0;
		for (int i = 0; i < costs.length; i++) {

			if (unionFind(edges[i].from, edges[i].to)) {
				totalCost += edges[i].weight;
				cnt++;
			}

			if (cnt == n - 1)
				break;
		}

		return totalCost;
	}

    // 루트 경로찾기
	public static int findRoot(int v) {

		if (v == roots.get(v))
			return v;

		roots.put(v, findRoot(roots.get(v)));
		return roots.get(v);
	}

    // 유니온 파인드
	public static boolean unionFind(int a, int b) {
		int A = findRoot(a);
		int B = findRoot(b);

		if (A == B)
			return false;

		roots.put(B, A);

		return true;
	}
}