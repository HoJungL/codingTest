import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Node {
		int x, y, keys;

		public Node(int x, int y, int keys) {
			this.x = x;
			this.y = y;
			this.keys = keys;
		}
	}

	private static int N;

	private static int M;

	private static char[][] matrix;
	private static boolean[][][] visited;
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);

		matrix = new char[N][M];
		visited = new boolean[N][M][64];

		int startX = 0;
		int startY = 0;

		for (int i = 0; i < N; i++) {
			String string = br.readLine();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = string.charAt(j);
				if (matrix[i][j] == '0') {
					startX = i;
					startY = j;
				}
			}
		}
		System.out.println(bfs(startX, startY));

	}

	private static int bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(i, j, 0));
		visited[i][j][0] = true;
		int steps = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int m = 0; m < size; m++) {
				Node current = queue.poll();
				int ex = current.x;
				int ey = current.y;
				int key = current.keys;

				if (matrix[ex][ey] == '1') {
					return steps;
				}
				for (int k = 0; k < 4; k++) {
					int nx = ex + dx[k];
					int ny = ey + dy[k];
					if (!isTrue(nx, ny)) {
						continue;
					}
					if (matrix[nx][ny] == '#' || visited[nx][ny][key]) {
						continue;
					}

					char cell = matrix[nx][ny];

					if (cell >= 'a' && cell <= 'f') {
						int newkey = key | (1 << (cell - 'a'));
						if (!visited[nx][ny][newkey]) {
							visited[nx][ny][newkey] = true;
							queue.add(new Node(nx, ny, newkey));
						}
					} else if (cell >= 'A' && cell <= 'F') {
						if ((key & (1 << (cell - 'A'))) != 0) {
							visited[nx][ny][key] = true;
							queue.add(new Node(nx, ny, key));
						}
					} else {
						visited[nx][ny][key] = true;
						queue.add(new Node(nx, ny, key));
					}
				}
			}
			steps++;
		}
		return -1;
	}

	private static boolean isTrue(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}
}