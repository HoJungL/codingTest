import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static class Node {
		public int vertex;
		public Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	}

	private static int V, E; // 정점 개수, 간선개수
	private static Node[] adjList; // 인접리스트
	private static int[] inDegree; // 인덱스 번호 : 정점번호, 진입 차수

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10; // 문제에서 테케 10개 고정
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			adjList = new Node[V + 1]; // 정점 번호는 1부터 시작 (0번 사용 안함)
			inDegree = new int[V + 1]; // 각 정점의 진입차수 기록

			st = new StringTokenizer(br.readLine(), " ");
			int from, to;
			for (int i = 0; i < E; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
				inDegree[to]++;
			}

			List<Integer> list = topologySort();
			for (int vertex : list) {
				sb.append(vertex + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());


	}

	private static List<Integer> topologySort() {
		List<Integer> orderList = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= V; i++) {
			// 1. 진입 차수가 0인 노드(시작점)을 큐에 모두 넣는다.
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			// 2. 큐에서 진입 차수가 0인 노드를 꺼내어 자신과 인접한 노드의 간선을 제거한다
			Integer cur = queue.poll();
			orderList.add(cur);

			for (Node temp = adjList[cur]; temp != null; temp = temp.link) {

				// 2. 인접한 노드의 진입 차수를 1 감소시킨다.
				if (--inDegree[temp.vertex] == 0) {
					// 3. 간선 제거 후 진입차수가 0이 된 노드를 큐에 넣는다.
					queue.add(temp.vertex);
				}
			}
		}
		return orderList;
	}
}