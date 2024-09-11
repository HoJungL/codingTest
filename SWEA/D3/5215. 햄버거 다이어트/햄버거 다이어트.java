import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#" + tc + " ");
			String[] split = in.readLine().split(" ");
			// 재료 수
			int n = Integer.parseInt(split[0]);
			// 칼로리
			int l = Integer.parseInt(split[1]);
			// 재료별 점수
			int[] T = new int[n + 1];
			// 재료별 칼로리
			int[] Kal = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				split = in.readLine().split(" ");
				T[i] = Integer.parseInt(split[0]);
				Kal[i] = Integer.parseInt(split[1]);
			}

			// dp
			int[][] D = new int[n + 1][l + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= l; j++) {
					// 만약에... 칼로리의 i보다 작으면
					if (j < Kal[i]) {
						D[i][j] = D[i - 1][j];
					} else {
						D[i][j] = Math.max(D[i - 1][j - Kal[i]] + T[i], D[i - 1][j]);
					}
				}
			}
			sb.append(D[n][l]).append("\n");
		}
		System.out.println(sb);
	}

}