import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	private static class Edge implements Comparable<Edge> {

//		public int weight;
		public int from; // 진출 정점번호
		public int to; // 진입 정점번호
		public int weight; // 가중치 정보

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// 나의 가중치에서 상대방의 가중치를 빼줄거임
			// 이 말의 뜻이 바로 가중치 기준으로 오름차순 정렬 한다는 뜻임!!
			return this.weight - o.weight;
		}

	}

	private static void makeSet() {

		// 정점 번호 0번부터 시작
		parents = new int[V];

		// 자신의 대표자를 자신의 정점 번호로 설정 -> 내가 대표임 빼액!!
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}

	}

	// 파라미터로 a를 넘기고 있는데
	// a의 집합을 찾기 위해서임
	// 즉, a의 대표자를 찾는거지.
	// 다시말해, a는 어디에 소속되어있거나, a 스스로 대표자일수도 있어!
	private static int findSet(int a) {

		// 정점 번호랑 대표자 번호가 같으면 지 스스로를 호출하세유
		if (parents[a] == a) {
			return a;
		}
		// 아니면 parents[a]의 대표자를 찾아..!! 찾으라고!!
//		return findSet(parents[a]);
		return parents[a] = findSet(parents[a]); // path compression
	}

	// a,b 두 집합을 합치는거야!!
	// 근데, a가 대표자가 아닐수도 있겠지??
	// 그렇게 되면 a의 대표자가 a를 몰고와서 한꺼번에 합쳐지는거란다!!
	private static boolean union(int a, int b) {

		int aRoot = findSet(a);
		int bRoot = findSet(b);

		// 이미 a정점과 b 정점이 같은 집합이면 false를 던지셈
		if (aRoot == bRoot) {
			return false;
		}
		// A가 새로운 집합의 대표자로 선정
		// 값이 대표자인거임.
		parents[bRoot] = aRoot;
		return true;
	}

	private static int V; // 나는야 정점
	private static int E; // 나는야 간선
	private static int T; // 나는야 테케 수
	private static int[] parents; // 나는 정보 담는 부모임 ㅎ
	private static Edge[] edgeList; // 인접 행렬

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			String[] split = in.readLine().split(" ");
			V = Integer.parseInt(split[0]);
			E = Integer.parseInt(split[1]);
			edgeList = new Edge[E]; // 객체임. 객체는? 디폴트값으로 초기화!!

			int from, to, weight;

			for (int i = 0; i < E; i++) {
				split = in.readLine().split(" ");
				from = Integer.parseInt(split[0]) - 1;
				to = Integer.parseInt(split[1]) - 1;
				weight = Integer.parseInt(split[2]);

				edgeList[i] = new Edge(from, to, weight);
			}
			Arrays.sort(edgeList);
//			System.out.println(Arrays.toString(edgeList));

			makeSet();

			long result = 0; // MST 비용
			int count = 0; // 연결 간선 수
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) { // 사이클이 발생하지 않으면 (같은 집합에 없다면)
					result += edge.weight;

					if (++count == V - 1) { // 연결 간선수가 정점수-1이면 다 연결한거다..!!
						break;
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}

}