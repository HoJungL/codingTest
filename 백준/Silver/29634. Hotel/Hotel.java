import java.io.*;
import java.util.*;

public class Main {
	private static int n, m;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] dimensions = in.readLine().split(" ");
		n = Integer.parseInt(dimensions[0]);
		m = Integer.parseInt(dimensions[1]);

		map = new char[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = in.readLine().toCharArray();
		}

		int max = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '.' && !visited[i][j]) {
					max = Math.max(max, bfs(i, j));
				}
			}
		}

		System.out.println(max);
	}

	private static int bfs(int startX, int startY) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { startX, startY });
		visited[startX][startY] = true;

		int minX = startX;
		int maxX = startX;
		int minY = startY;
		int maxY = startY;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];

			// Check all 4 directions
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (isValid(nx, ny) && map[nx][ny] == '.' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] { nx, ny });

					// Update the bounding box
					minX = Math.min(minX, nx);
					maxX = Math.max(maxX, nx);
					minY = Math.min(minY, ny);
					maxY = Math.max(maxY, ny);
				}
			}
		}

		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				if (map[i][j] != '.') {
					return 0;
				}
			}
		}

		if (!isSurround(minX, maxX, minY, maxY)) {
			return 0;
		}

		return (maxX - minX + 1) * (maxY - minY + 1);
	}

	private static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	private static boolean isSurround(int minX, int maxX, int minY, int maxY) {
		for (int j = minY; j <= maxY; j++) {
			if (minX - 1 >= 0 && map[minX - 1][j] != '*')
				return false;
			if (maxX + 1 < n && map[maxX + 1][j] != '*')
				return false;
		}
		
		
		for (int i = minX; i <= maxX; i++) {
			if (minY - 1 >= 0 && map[i][minY - 1] != '*')
				return false;
			if (maxY + 1 < m && map[i][maxY + 1] != '*')
				return false;
		}

		return true;
	}
}