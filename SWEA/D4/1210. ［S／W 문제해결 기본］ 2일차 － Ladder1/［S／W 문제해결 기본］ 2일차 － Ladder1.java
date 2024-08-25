import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	// 상 하 좌 우
	private static final int[] dx = { 0, 0, -1, 1 };
	private static final int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 테케 수
		int T = 10;
		int[][] matrix = new int[100][100];
		for (int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#" + test_case+ " ");
			int tcN = Integer.parseInt(in.readLine());

			// 데이터 넣자
			for (int i = 0; i < 100; i++) {
				String[] split = in.readLine().split(" ");
				for (int j = 0; j < 100; j++) {
					matrix[i][j] = Integer.parseInt(split[j]);
				}
			}
			// 도착점을 우선 찾아요
			int startX = 0;
			int startY = 99;
			for (int i = 0; i < 100; i++) {
				if (matrix[startY][i] == 2) {
					startX = i;
					break;
				}
			}

			// 역추적합시다.
			// 왼쪽방문
			while (startY > 0) {
				if (startX > 0 && matrix[startY][startX - 1] == 1) {
					while (startX>0 &&matrix[startY][startX - 1] == 1) {
						startX--;
					}
				}
				// 오른쪽 방문
				else if (startX < 99 && matrix[startY][startX + 1] == 1) {
					while (startX < 99 &&matrix[startY][startX + 1] == 1) {
						startX++;
					}
				} 
				startY--;
			}
			sb.append(startX).append("\n");

		}
		System.out.println(sb);
	}
}