import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 번째 줄 입력
        st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 맵 입력
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 배열
        int[][] dp = new int[n][m];

        // 첫 번째 행 초기화
        dp[0][0] = map[0][0];
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + map[0][j];
        }

        // 두 번째 행~
        for (int i = 1; i < n; i++) {
            // 왼쪽에서 오는 경우
            int[] left = new int[m];
            left[0] = dp[i - 1][0] + map[i][0];
            for (int j = 1; j < m; j++) {
                left[j] = Math.max(left[j - 1], dp[i - 1][j]) + map[i][j];
            }

            // 오른쪽에서 오는 경우 저장
            int[] right = new int[m];
            right[m - 1] = dp[i - 1][m - 1] + map[i][m - 1];
            for (int j = m - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dp[i - 1][j]) + map[i][j];
            }

            // 왼쪽과 오른쪽 값을 비교하여 dp 갱신
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        // 결과 출력
        System.out.println(dp[n - 1][m - 1]);
    }
}
