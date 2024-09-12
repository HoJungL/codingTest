import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	// 좌표
	static Point[] point;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스
		int t = Integer.parseInt(in.readLine());
		// 편의점 개수
		for (int i = 0; i < t; i++) {
			int beer = Integer.parseInt(in.readLine());
			point = new Point[beer + 2];
			visited = new boolean[beer + 2];

			for (int j = 0; j < beer + 2; j++) {
				String[] split = in.readLine().split(" ");
				int x = Integer.parseInt(split[0]);
				int y = Integer.parseInt(split[1]);
				point[j] = new Point(x, y);
			}
			String result = bfs(point[0].x, point[0].y);
			System.out.println(result);
		}
	}

	private static String bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(x, y));
		visited[0] = true;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			int ex = current.x;
			int ey = current.y;

			if (ex == point[point.length - 1].x && ey == point[point.length - 1].y) {
				return "happy";
			}

			for (int i = 1; i < point.length; i++) {
				if (!visited[i]) {
					int distance = Math.abs(current.x - point[i].x) + Math.abs(current.y - point[i].y);
					if (distance <= 1000) {
						visited[i] = true;
						queue.add(point[i]);
					}
				}
			}
		}

		return "sad";
	}
}