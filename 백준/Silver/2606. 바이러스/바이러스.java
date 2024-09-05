import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


public class Main {
	// 컴퓨터 수
	static int computer;
	// 쌍의 수
	static int couple;
	// 인접행렬로 풀어볼까...
	static int[][] adjMatrix;
	static String[] split;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		computer = Integer.parseInt(br.readLine());
		couple = Integer.parseInt(br.readLine());
		adjMatrix = new int[computer][computer];
		visited = new boolean[computer];
		int from, to;
		for (int i = 0; i < couple; i++) {
			split = br.readLine().split(" ");
			from = Integer.parseInt(split[0]) -1;
			to = Integer.parseInt(split[1]) -1;

			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		
		bfs(0);
		count =0;
		for (boolean visit : visited) {
			if (visit) {
				count++;
			}
		}
		System.out.println(count-1);
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();

		queue.offer(start); // 큐에 넣어 방문 예약
		visited[start] = true; // 큐에 넣을땐 반드시 방문체크함.

		int current = 0;
		while (!queue.isEmpty()) {
			current = queue.poll();

			for (int i = 0; i < computer; i++) {
				// 인접하고 방문하지 않은 정점이면
				if (adjMatrix[current][i] != 0 && !visited[i]) { // 현재 정점과 인접한 정점이 뭔지 확인
					queue.offer(i); // 큐에 넣어서 방문 예약
					visited[i] = true; // 큐에 넣을땐 반드시 방문체크 한다.
				}
			}
		}
	}

}