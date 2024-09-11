import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static int[][] matrix;
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            N = Integer.parseInt(in.readLine());
            matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] split = in.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(split[j]);
                }
            }

            min = Integer.MAX_VALUE;
            solve();
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve() {
        int totalStates = 1 << N; // 2^N possible states
        int[] dp = new int[totalStates];
        int[] groupSum = new int[totalStates];

        // Initialize the dp array
        for (int i = 0; i < totalStates; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // Iterate over all possible subsets
        for (int mask = 0; mask < totalStates; mask++) {
            int count = Integer.bitCount(mask);
            if (count == N / 2) { // If this subset is of size N/2
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        if (((mask >> i) & 1) == 1 && ((mask >> j) & 1) == 1) {
                            sum += matrix[i][j] + matrix[j][i];
                        }
                    }
                }
                groupSum[mask] = sum;
                int complement = ((1 << N) - 1) ^ mask; // Complement subset
                if (Integer.bitCount(complement) == N / 2) {
                    int diff = Math.abs(groupSum[mask] - groupSum[complement]);
                    min = Math.min(min, diff);
                }
            }
        }
    }
}