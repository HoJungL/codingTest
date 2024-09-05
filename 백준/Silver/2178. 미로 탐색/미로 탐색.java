import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N;
	static int M;
	static int[][] matrix;
	static boolean[][] visited;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		matrix = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			split = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(split[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		System.out.println(matrix[N-1][M-1]);

	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[i][j] = true;
		queue.add(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int ex = current[0];
			int ey = current[1];
			for (int k = 0; k < 4; k++) {
				int nx = ex + dx[k];
				int ny = ey + dy[k];
				if (isTrue(nx,ny) && !visited[nx][ny] && matrix[nx][ny]==1) {
					visited[nx][ny] = true;
					matrix[nx][ny] = matrix[ex][ey] +1;
					queue.add(new int[] {nx,ny});
				}
			}

		}
	}

	private static boolean isTrue(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

}