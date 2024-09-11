import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		// 물품의 수
		int N = Integer.parseInt(split[0]);
		// 버틸수 있는 최대 무게
		int K = Integer.parseInt(split[1]);

		// 각 물품의 무게
		int[] W = new int[N + 1];
		// 각 물품의 가치
		int[] V = new int[N + 1];

		// 1. 동적 테이블 만들깅 -> 물품수, 버틸수 있는 최대무게
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			split = in.readLine().split(" ");
			W[i] = Integer.parseInt(split[0]);
			V[i] = Integer.parseInt(split[1]);
		}
		// 베이스값은 채웠고. 배낭 기본값은 0 이니까 테이블 초기화도 안해도 되고.

		// 3. 점화식 이용
		int itemW = 0;
		int itemV = 0;
		for (int item = 1; item <= N; item++) {
			itemW = W[item]; // 현 아이템의 무게
			itemV = V[item]; // 현 아이템의 가치

			// 점화식 ㄱㄱ
			for (int weight = 1; weight <= K; weight++) {

				// 현 아이템 선택시
				if (itemW <= weight) {
					dp[item][weight] = Math.max(dp[item - 1][weight], itemV + dp[item - 1][weight - itemW]);
				} else {
					dp[item][weight] = dp[item - 1][weight];
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}