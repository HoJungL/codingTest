import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	private static int N;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static List<Integer> answer;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		matrix = new int[N][N];
		visited = new boolean[N][N];
		answer = new ArrayList<>();
		count = 0;

		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split("");
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(split[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 1 && !visited[i][j]) {
					// 방문 체크 표시
					visited[i][j] = true;
					// dfs로 값 크기 구하기
					// 결과값을 리스트에 넣어주기.
					count = 0;
					dfs(i, j);
					answer.add(count);
				}
			}
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for (int i : answer) {
			System.out.println(i);
		}

	}

	private static void dfs(int i, int j) {
		// TODO Auto-generated method stub
		count++;
		for (int k = 0 ; k<4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if (isTrue(nx,ny)) {
				if (matrix[nx][ny]==1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					// 호출하깅
					dfs(nx,ny);
				}
			}
		}
	}

	public static boolean isTrue(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N;
	}

}