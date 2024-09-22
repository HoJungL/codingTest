
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 간선 클래스
	static class Edge {
		int from, to, weight;

		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	// 유니온 파인드
	static class Union {
		int[] parent;

		Union(int size) {
			parent = new int[size];
			for (int i = 0; i < size; i++) {
				parent[i] = i;
			}
		}

		int findSet(int x) {
			if (parent[x] != x) {
				parent[x] = findSet(parent[x]);
			}
			return parent[x];
		}

		boolean union(int x, int y) {
			int rootX = findSet(x);
			int rootY = findSet(y);
			if (rootX != rootY) {
				parent[rootY] = rootX;
				return true;
			}
			return false;
		}
	}

	public int solution(int[][] land, int height) {
		int answer = 0;
		int n = land.length;
		List<Edge> edges = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int currentH = land[i][j];
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
						int neightH = land[nx][ny];
						int cost = Math.abs(currentH-neightH);

						// 이동 비용을 결정
						if (cost > height) {
							edges.add(new Edge(i * n + j, nx * n + ny, cost));
						} else {
							edges.add(new Edge(i * n + j, nx * n + ny, 0));
						}
					}
				}
			}
		}
		Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

		Union union = new Union(n * n);
		for (Edge edge : edges) {
			if (union.union(edge.from, edge.to)) {
				answer += edge.weight;
			}
		}

		return answer;
	}
}