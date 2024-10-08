class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            // 맨 왼쪽 경로
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            // 중간 경로
            for (int j = 1; j < triangle[i].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        // 마지막 행에서 가장 큰 값 찾기
        int answer = 0;
        for (int i = 0; i < dp[n-1].length; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }

        return answer;
    }
}