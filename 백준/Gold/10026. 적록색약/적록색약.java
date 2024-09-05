import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	static int N;
	static String[][] matrix;
	static boolean[][] visited;
	// 정상인꺼 count
	static int count;
	// 적록 색약 count
	static int rgCount;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new String[N][N];
		visited = new boolean[N][N];
		count = 0;
		rgCount = 0;

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				matrix[i][j] = split[j];
			}
		}
		// 정상
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, false);
					count++;
				}
			}
		}
		// 색약
		// 초기화...
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, true);
					rgCount++;
				}
			}
		}
		System.out.println(count + " " + rgCount);
	}

	private static void bfs(int i, int j, boolean rg) {
		visited[i][j] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { i, j });
		String currentColor = matrix[i][j];

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int ex = current[0];
			int ey = current[1];
			for (int k = 0; k < 4; k++) {
				int nx = ex + dx[k];
				int ny = ey + dy[k];

				if (isTrue(nx, ny) && !visited[nx][ny]) {
					String nextColor = matrix[nx][ny];
					if (rg) {
						if (currentColor.equals("R") || currentColor.endsWith("G")) {
							if (nextColor.equals("R") || nextColor.equals("G")) {
								queue.add(new int[] { nx, ny });
								visited[nx][ny] = true;
							}
						} else if (currentColor.equals("B")) {
							if (nextColor.equals("B")) {
								queue.add(new int[] { nx, ny });
								visited[nx][ny] = true;
							}
						}
					} else {
						if (nextColor.equals(currentColor)) {
							queue.add(new int[] { nx, ny });
							visited[nx][ny] = true;
						}
					}
				}
			}

		}

	}

	private static boolean isTrue(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N;
	}
}