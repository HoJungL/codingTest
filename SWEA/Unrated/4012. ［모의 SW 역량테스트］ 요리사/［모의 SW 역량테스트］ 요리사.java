import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int[][] matrix;
	static boolean[] visited;
	static int N;
	static StringBuilder sb = new StringBuilder();
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 테케
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			// 식재료 수
			N = Integer.parseInt(in.readLine());
			matrix = new int[N][N];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				String[] split = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(split[j]);
				}
			}
			min = Integer.MAX_VALUE;
			combination(0, 0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);

	}

	private static void combination(int i, int j) {
		if (j == N / 2) {
			diff();
			return;
		}

		for (int idx = i; idx < N; idx++) {
			if (!visited[idx]) {
				visited[idx] = true;
				combination(idx + 1, j + 1);
				visited[idx] = false;
			}
		}
	}

	private static void diff() {
		int first = 0;
		int second = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
					first += matrix[i][j];
					first += matrix[j][i];
				} else if (!visited[i] && !visited[j]) {
					second += matrix[i][j];
					second += matrix[j][i];
				}
			}
		}
		int diff = Math.abs(first - second);

		min = Math.min(min, diff);
	}

}