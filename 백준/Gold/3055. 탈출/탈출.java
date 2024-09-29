import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	// 방향 탐색
	public static final int[] dx = { 1, 0, -1, 0 };
	public static final int[] dy = { 0, 1, 0, -1 };

	// 행, 열 개수
	private static int R, C;

	// 데이터 담자
	private static String[][] map;

	// 방문 체크
	private static boolean[][] visited;

	// D : 비버 굴
	public static int endX, endY;

	// S ; 고슴도치 위치
	public static int startX, startY;

	// 물 위치
	private static Queue<int[]> water = new ArrayDeque<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);

		map = new String[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			split = in.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = split[j];
				if (split[j].equals("D")) {
					endX = i;
					endY = j;
				}
				if (split[j].equals("S")) {
					startX = i;
					startY = j;
				}
				if (split[j].equals("*")) {
					water.add(new int[] { i, j });
				}
			}
		}
		int result = bfs(startX, startY);
		if (result == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(result);
		}
	}

	private static int bfs(int i, int j) {
		int time = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			water();
			for (int s = 0; s < size; s++) {
				int[] current = queue.poll();
				int ex = current[0];
				int ey = current[1];
				if (ex == endX && ey == endY) {
					return time;
				}

				for (int k = 0; k < 4; k++) {
					int nx = ex + dx[k];
					int ny = ey + dy[k];
					if (isVaild(nx, ny) && !visited[nx][ny] && map[nx][ny].equals(".")) {
						visited[nx][ny] = true;
						queue.add(new int[] { nx, ny });
					}
					if (isVaild(nx, ny) && !visited[nx][ny] && map[nx][ny].equals("D")) {
                        return time + 1;
                    }
				}
			}
			time++;
		}
		return -1;
	}

	private static void water() {
		int size = water.size();
		for (int s = 0; s < size; s++) {
			int[] current = water.poll();
			int wx = current[0];
			int wy = current[1];

			for (int k = 0; k < 4; k++) {
				int nx = wx + dx[k];
				int ny = wy + dy[k];

				if (isVaild(nx, ny) && map[nx][ny].equals(".")) {
					map[nx][ny] = "*";
					water.add(new int[] { nx, ny });

				}
			}
		}
	}

	private static boolean isVaild(int i, int j) {
		return i >= 0 && i < R && j >= 0 && j < C;
	}

}