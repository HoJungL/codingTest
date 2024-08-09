import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main {
	private static int N; // 정점의 개수
	private static int M; // 간선의 개수
	private static int V; // 탐색을 시작할 번호 V
	private static ArrayList<Integer>[] adjList;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {

		// 입력 받기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		V = Integer.parseInt(split[2]) - 1;

		adjList = new ArrayList[N];
		for (int i =0; i<N ; i++) {
			adjList[i] = new ArrayList<>();
		}
		visited = new boolean[N];
		int from, to;
		for (int i = 0; i<M; i++) {
			String[] split2 = in.readLine().split(" ");
			from = Integer.parseInt(split2[0])-1;
			to = Integer.parseInt(split2[1])-1 ;
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for (int i = 0 ; i<N; i++) {
			Collections.sort(adjList[i]);
		}


		dfs(V, new boolean[N]);
		System.out.println();
		bfs(V);
	}



	private static void dfs(int current, boolean[] visited) {

		visited[current] = true; // 해당 정점 방문여부 체크하고
		System.out.print(current+1 + " "); // 정점에서 할 일 하기!

		// 자신의 인접 정점 확인
		for (int vertex : adjList[current]) {
			if (!visited[vertex]) { // 이동할 정점을 방문 했는지 확인
				dfs(vertex, visited); // 방문
			}
		}
	}
	
	private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N];

        queue.offer(start); // 시작 정점 추가
        visited[start] = true; // 시작 정점 방문 표시

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print((current + 1) + " "); // 정점에서 할 일 하기!

            // 자신의 인접 정점 확인
            for (int vertex : adjList[current]) {
                if (!visited[vertex]) { // 이동할 정점을 방문 했는지 확인
                    queue.offer(vertex); // 큐에 추가
                    visited[vertex] = true; // 방문 표시
                }
            }
        }
	}

	
}