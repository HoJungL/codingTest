import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	private static class Node implements Comparable<Node> {
		public int x;
		public int y;
		public int cost;

		public Node(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.cost, other.cost);
		}

	}

	private static int[][] map;
	private static boolean[][] visited;
	private static int s = 1;

	private static int N;
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			N = Integer.parseInt(in.readLine());
			if (N == 0) {
				break;
			}
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String[] split = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(split[j]);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

				}
			}
			int result = dij(0, 0);

			System.out.println("Problem " + s + ": " + result);
			s++;

		}

	}

	private static int dij(int i, int j) {
		Queue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(i, j, map[i][j]));
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			if (current.x == N - 1 && current.y == N - 1) {
				return current.cost;
			}

			for (int k = 0; k < 4; k++) {
				int nx = current.x + dx[k];
				int ny = current.y + dy[k];

				if (isValid(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Node(nx, ny, current.cost + map[nx][ny]));
				}
			}
		}
		return 0;
	}
	private static boolean isValid(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N;
	}

}