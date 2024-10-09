class Solution {
    public int solution(int [][] board) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        int n = 0;
        int[][] dp = new int[row][col];

        // 일단 n이 젤길어야해. 행의 첫번째에 n의 값 (0 or 1)을 넣어주어요.
        for (int i = 0 ; i<row; i++){
            dp[i][0] = board[i][0];
            n = Math.max(n,dp[i][0]);
        }
        // 이하 동문
        for (int i = 0 ; i<col; i++){
            dp[0][i] = board[0][i];
            n = Math.max(n,dp[0][i]);
        }
        // 완탐 하면서...
        for (int i = 1 ; i<row; i++){
            for (int j = 1 ; j<col;j++){
                // 만약에 값이 1이면..
                if(board[i][j] == 1){
                    // dp[i][j] 전행, 전열, 왼쪽위에 0이 있는지 파악을 해요. 
                    // 만약에 다 1이면.. dp[i][j]의 길이는 2가 되겠군요.
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) +1;
                    n = Math.max(n, dp[i][j]);
                }
            }
        }
        answer = n * n;
        return answer;
    }
}
