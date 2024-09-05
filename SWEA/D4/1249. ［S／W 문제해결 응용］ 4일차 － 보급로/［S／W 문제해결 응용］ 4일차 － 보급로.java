import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	static int T;
	static int N;
	static int[][] matrix;
	static int[][] time;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static String[] split;
	static StringBuilder sb = new StringBuilder();

	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			time = new int[N][N];

			for (int i = 0; i < N; i++) {
				split = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(split[j]);
					time[i][j] = Integer.MAX_VALUE;
				}
			}

			bfs(0, 0);

			sb.append(time[N - 1][N - 1]).append("\n");
		}
		System.out.println(sb);

	}

	private static void bfs(int i, int j) {
		time[0][0] = 0;
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		queue.add(new int[] { i, j, 0 });
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int ex = current[0];
			int ey = current[1];
			int newTime = current[2];
			if (newTime > time[ex][ey]) {
				continue;
			}
			for (int k = 0; k < 4; k++) {
				int nx = ex + dx[k];
				int ny = ey + dy[k];
				if (isTrue(nx, ny)) {
					int finalTime = matrix[nx][ny] + newTime;
					if (finalTime < time[nx][ny]) {
						time[nx][ny] = finalTime;
						queue.add(new int[] { nx, ny, finalTime });
					}
				}

			}
		}
	}

	private static boolean isTrue(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N;
	}
}