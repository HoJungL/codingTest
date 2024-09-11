import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//
		String[] split = in.readLine().split(" ");
		// 가동중인 앱수
		int N = Integer.parseInt(split[0]);
		// 필요한 메모리 양
		int M = Integer.parseInt(split[1]);

		// 활성화한 앱의 사용중인 메모리
		int[] apps = new int[N + 1];
		split = in.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			apps[i] = Integer.parseInt(split[i - 1]);
		}
		// 비활성화시 사용되는 비용
		int[] costs = new int[N + 1];
		split = in.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			costs[i] = Integer.parseInt(split[i - 1]);
		}
		int maxCost = 0;
		for (int i = 1; i <= N; i++) {
			maxCost += costs[i];
		}

		int[] dp = new int[maxCost + 1];

		// 3. 점화식
		for (int i = 1; i <= N; i++) {
			for (int j = maxCost; j >= costs[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - costs[i]] + apps[i]);
			}
		}
		int result = Integer.MAX_VALUE;
		for (int j = 0; j <= maxCost; j++) {
			if (dp[j] >= M) {
				result = Math.min(result, j);
				break;
			}
		}
		System.out.println(result);
	}
}