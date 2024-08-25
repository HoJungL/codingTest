import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테케 수
		int T = 10;
		// 배열의 크기 : 100x100
		int[][] matrix = new int[100][100];

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			max = Integer.MIN_VALUE;
			// 테케 번호
			int tcNumber = Integer.parseInt(in.readLine());
			// 데이터 넣공
			for (int i = 0; i < 100; i++) {
				String[] split = in.readLine().split(" ");
				for (int j = 0; j < 100; j++) {
					matrix[i][j] = Integer.parseInt(split[j]);
				}
			}
			// 가로 최댓값
			for (int i = 0; i < 100; i++) {
				int sum = 0;

				for (int j = 0; j < 100; j++) {
					sum += matrix[i][j];
				}
				if (max < sum) {
					max = sum;
				}
			}
			// 세로 최댓값
			for (int i = 0; i < 100; i++) {
				int sum = 0;

				for (int j = 0; j < 100; j++) {
					sum += matrix[j][i];
				}
				if (max < sum) {
					max = sum;
				}
			}
			// 대각선 왼쪽위 -> 오른쪽 아래
			int sum = 0;

			for (int i = 0; i < 100; i++) {
				sum += matrix[i][i];
				if (max < sum) {
					max = sum;
				}
			}
			// 대각선 오른쪽위 -> 왼쪽 아래
			sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += matrix[i][99 - i];
				if (max < sum) {
					max = sum;
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}