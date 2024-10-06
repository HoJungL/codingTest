import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

	// 테케 수
	private static int T = 10;

	// 방향
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	// 전체 크기
	private static int N = 16;

	// 크기만큼의 맵
	private static int[][] map;

	// 방문처리
	private static boolean[][] visited;
	// 출발지점, 도착지점
	private static int startX;
	private static int startY;
	private static int endX;
	private static int endY;
	// 출력
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			// 몇번째인지 출력하려는거. -> 필요없음
			String noUse = in.readLine();
			map = new int[N][N];
			visited = new boolean[N][N];
			startX = 0;
			startY = 0;
			endX = 0;
			endY = 0;
			// 데이터 입력
			for (int i = 0; i < N; i++) {
				String[] split = in.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(split[j]);

					if (map[i][j] == 2) {
						startX = i;
						startY = j;
					}
					if (map[i][j] == 3) {
						endX = i;
						endY = j;
					}
				}
			}
			sb.append(bfs(startX, startY)).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int ex = current[0];
			int ey = current[1];
			for (int k = 0; k < 4; k++) {
				int nx = ex + dx[k];
				int ny = ey + dy[k];
				if (nx == endX && ny == endY) {
					return 1;
				}
				if (!visited[nx][ny] && map[nx][ny] == 0) {
					visited[nx][ny] = true;
					queue.add(new int[] { nx, ny });
				}
			}

		}

		return 0;
	}

	private static boolean isVaild(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N;
	}

}