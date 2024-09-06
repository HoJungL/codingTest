import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	// 말처럼 뛰는거
	static int[] dx = { 2, 2, 1, -1, -2, -2, -1, 1 };
	static int[] dy = { -1, 1, 2, 2, 1, -1, -2, -2 };
	// 일반 몹
	static int[] dx2 = { 1, 0, -1, 0 };
	static int[] dy2 = { 0, 1, 0, -1 };
	static int w;
	static int h;
	static int K;
	static int[][] matrix;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// k
		K = Integer.parseInt(in.readLine());
		// w,h
		String[] st = in.readLine().split(" ");
		w = Integer.parseInt(st[0]);
		h = Integer.parseInt(st[1]);

		matrix = new int[h][w];
		visited = new boolean[h][w][K + 1];
		for (int i = 0; i < h; i++) {
			st = in.readLine().split(" ");
			for (int j = 0; j < w; j++) {
				matrix[i][j] = Integer.parseInt(st[j]);
			}
		}
		System.out.println(bfs(0, 0));
	}

	private static int bfs(int i, int j) {
		int result = 0;
		visited[i][j][0] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { i, j, 0 });
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] current = queue.poll();
				int x = current[0];
				int y = current[1];
				int horse = current[2];
				// 도착지점에 도달하면 이동 횟수를 반환
				if (x == h - 1 && y == w - 1) {
					return result;
				}
				for (int k = 0; k < 4; k++) {
					int nx = x + dx2[k];
					int ny = y + dy2[k];
					if (isTrue(nx, ny) && !visited[nx][ny][horse] && matrix[nx][ny] == 0) {
						visited[nx][ny][horse] = true;
						queue.add(new int[] { nx, ny, horse });
					}
				}
				if (horse < K) {
					for (int k = 0; k < 8; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (isTrue(nx, ny) && !visited[nx][ny][horse + 1] && matrix[nx][ny] == 0) {
							visited[nx][ny][horse + 1] = true;
							queue.add(new int[] { nx, ny, horse + 1 });
						}
					}
				}
			}
			result++;
		}
		return -1;

	}

	private static boolean isTrue(int i, int j) {
		return i >= 0 && i < h && j >= 0 && j < w;
	}
}