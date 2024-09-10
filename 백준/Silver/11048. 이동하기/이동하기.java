import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// https://www.acmicpc.net/problem/11048
public class Main {
	static int N, M;
	static int[][] matrix;
	static int[][] D;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		matrix = new int[N][M];
		D = new int[N][M];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(split[j]);
			}
		}
		D[0][0] = matrix[0][0];


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i > 0) {
					D[i][j] = Math.max(D[i][j], D[i - 1][j] + matrix[i][j]);
				}
				if (j > 0) {
					D[i][j] = Math.max(D[i][j], D[i][j - 1] + matrix[i][j]);
				}
			}
		}
		System.out.println(D[N-1][M-1]);

	}
//		bfs(0, 0);
//	private static void bfs(int i, int j) {
//		visited[i][j] = true;
//		Queue<int[]> queue = new ArrayDeque<>();
//		queue.add(new int[] { i, j });
//		while (!queue.isEmpty()) {
//			int[] current = queue.poll();
//			int x = current[0];
//			int y = current[1];
//			for (int k = 0; k < 3; k++) {
//				int nx = x + row[k];
//				int ny = y + col[k];
//				if (isVaild(nx, ny)) {
//					if (!visited[nx][ny]) {
//						int max = Math.max(D[x][y], D[nx][ny]);
//						D[nx][ny] = max + matrix[nx][ny];
//
//						visited[nx][ny] = true;
//						queue.add(new int[] { nx, ny });
//						visited[nx][ny] = false;
//
//					}
//				}
//			}
//		}
//	}
}