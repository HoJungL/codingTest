import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	// tc
	static int T;
	// N
	static int N;
	// trees
	static int[] trees;
	// maxhe
	static int maxHeight;
	// 출력
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			N = Integer.parseInt(in.readLine());
			trees = new int[N];
			String[] split = in.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(split[i]);
			}
			Arrays.sort(trees);
			maxHeight = trees[N - 1];

			int odd = 0, even = 0;
			for (int i = 0; i < trees.length; i++) {
				int diff = maxHeight - trees[i];
				if (diff == 0) {
					continue;
				}
				even += diff / 2;
				odd += diff % 2;
			}
			if (even > odd) {
				while (Math.abs(even - odd) > 1) {
					even--;
					odd += 2;
				}
			}
			int result = 0;
			if (even > odd) {
				result += even * 2;
			} else if (odd > even) {
				result += odd * 2 - 1;
			} else {
				result += odd + even;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}