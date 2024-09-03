import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int N;
	private static int M;
	private static int[][] matrix;
	private static boolean[][] visited;
	private static int count;
	private static final int[] dx = { 0, 0, -1, 1 };
	private static final int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		matrix = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(split[j]);
			}
		}
		count = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					// 전체 그림 갯수를 +1
					count++;
					// 그림의 크기를 구해주고,
					max = Math.max(max, bfs(i, j));
					// 최댓값에 갱신
				}
			}
		}
		System.out.println(count);
		System.out.println(max);

	}

	private static int bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<int[]> queue = new LinkedList<>();
		int result = 1;
		queue.add(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] a = queue.poll();
			int ex = a[0];
			int ey = a[1];
			for (int k = 0; k < 4; k++) {
				int nx = ex + dx[k];
				int ny = ey + dy[k];
				if (isTrue(nx, ny)) {
					if (matrix[nx][ny] == 1 && !visited[nx][ny]) {
						result++;
						visited[nx][ny] = true;
						queue.add(new int[] {nx,ny});
					}

				}
			}
		}
		return result;
	}

	private static boolean isTrue(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

}