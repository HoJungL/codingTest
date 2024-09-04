import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int R;
	static int C;
	static String[][] matrix;
	static boolean[][] visited;
	static int count;
	// 우 우상 우하// 우상, 우, 우하
	static final int[] dx = {-1, 0, 1};
	static final int[] dy = {1, 1, 1};


	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		matrix = new String[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			split = in.readLine().split("");
			for (int j = 0; j < C; j++) {
				matrix[i][j] = split[j];
			}
		}

		for (int i = 0; i < R; i++) {
			if (dfs(i, 0)) {
				count++;
			}
		}

		System.out.println(count);

	}

	private static boolean dfs(int i, int j) {
		visited[i][j] = true;

		if (j == C - 1) {
			return true;
		}
		for (int k = 0; k < 3; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if (isTrue(nx, ny) && !visited[nx][ny] && matrix[nx][ny].equals(".")) {
				if (dfs(nx, ny)) {
					return true;
				}
			}
		}
		return false;

	}

	private static boolean isTrue(int i, int j) {
		return i >= 0 && i < R && j >= 0 && j < C;
	}

}