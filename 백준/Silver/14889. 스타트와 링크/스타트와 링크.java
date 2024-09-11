import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] matrix;
	static boolean[] visited;
	static int N;
	static int min;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
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
		System.out.println(min);
	}

	private static void combination(int i, int j) {
		if (j == N / 2) {
			int start = 0;
			int link = 0;
			for (int k = 0; k < N - 1; k++) {
				for (int m = k + 1; m < N; m++) {
					if (visited[k] && visited[m]) {
						start += matrix[k][m];
						start += matrix[m][k];
					} else if (!visited[k] && !visited[m]) {
						link += matrix[k][m];
						link += matrix[m][k];
					}
				}
			}
			int diff = Math.abs(start - link);
			min = Math.min(min, diff);
		}
		for (int k = i; k < N; k++) {
			if (!visited[k]) {
				visited[k] = true;
				combination(k + 1, j + 1);
				visited[k] = false;
			}
		}
	}
}