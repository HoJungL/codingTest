import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	private static class Node {
		public int vertex;
		public Node link;
		public int weight;

		public Node(int vertex, Node link, int weight) {
			super();
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + ", weight=" + weight + "]";
		}

	}

	private static final int INF = Integer.MAX_VALUE;

	private static int V; // 정점의 개수
	private static int E; // 간선의 개수

	public static void main(String[] args) throws Exception {
		// 데이터 받고
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 데이터 나누고
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// 출발 정점 입력하고
		int start = Integer.parseInt(in.readLine());

		// 정점 수만큼 Node 배열 만들고
		Node[] adjList = new Node[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, adjList[from], weight);
		}

		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(distance, INF);

		distance[start] = 0;

		int min = 0;
		int current = 0;

		for (int cnt = 0; cnt < V; cnt++) {
			current = -1;
			min = INF;

			for (int i = 1; i <= V; i++) {
				if (!visited[i] && distance[i] < min) {
					min = distance[i];
					current = i;
				}
			}

			// (선택사항) 가지치기 : 정점을 못 찾은 경우는 종료
			if (current == -1) {
				break;
			}
			visited[current] = true;

			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex] 
						&& distance[temp.vertex] > min + temp.weight) {
					distance[temp.vertex] = min + temp.weight;
				}
			}

		}
		for (int i = 1; i < distance.length; i++) {
			System.out.println(distance[i] != INF ? distance[i] : "INF");
		}
	}

}