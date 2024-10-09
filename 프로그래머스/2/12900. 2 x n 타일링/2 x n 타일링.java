class Solution {
    public int solution(int n) {
        int 나누기 = 1000000007;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n; i++){
            dp[i] = (dp[i-1]+ dp[i-2]) % 나누기;
        }
        int answer = dp[n];
        return answer;
    }
}