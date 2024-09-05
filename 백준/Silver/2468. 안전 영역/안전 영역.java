
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	private static int N;
	static int[][] matrix;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static int maxSafe = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		matrix = new int[N][N];
		visited = new boolean[N][N];
		int maxHeight = 0;

		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(split[j]);
				if (matrix[i][j] > maxHeight) {
					maxHeight = matrix[i][j];
				}
			}
		}

		for (int h = 0; h <= maxHeight; h++) {
			visited = new boolean[N][N];
			int safe = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] > h && !visited[i][j]) {
						safe++;

						bfs(i, j, h);
					}
				}
			}
			if (safe > maxSafe) {
				maxSafe = safe;
			}
		}
		System.out.println(maxSafe);
	}

	private static void bfs(int i, int j, int height) {
		visited[i][j] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (isTrue(nx, ny)) {
					if (matrix[nx][ny] > height && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new int[] { nx, ny });
					}
				}
			}
		}
	}

	private static boolean isTrue(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N;
	}

}