import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int N = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] A = new int[N]; // 수열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 생성
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1; 
        }

        // LIS 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) { // 증가 조건
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 결과 출력 (DP 배열의 최댓값)
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println(maxLength);
    }
}