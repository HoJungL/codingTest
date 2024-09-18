class Solution {
    private static int answer = 0; // 놓을 수 있는 퀸의 수
    private static int N; // 한 변의 길이
    private static boolean[] col; // 각 열에 퀸이 있는지 체크
    private static boolean[] diag1; // 대각선 체크 (r - c)
    private static boolean[] diag2; // 대각선 체크 (r + c)

    public int solution(int n) {
        N = n;
        col = new boolean[n + 1];
        diag1 = new boolean[2 * n]; // 대각선 (r - c) 범위: -(n-1) ~ (n-1)
        diag2 = new boolean[2 * n]; // 대각선 (r + c) 범위: 0 ~ (2n-2)
        setQueens(1); // 1행부터 시도
        return answer;
    }
    
    private static void setQueens(int rowNo) {
        // 기저 조건
        if (rowNo > N) {
            answer++;
            return;
        }

        // 유도 부분
        for (int j = 1; j <= N; j++) { // 해당 행의 1열부터 N열까지 퀸 놓는 시도
            if (!col[j] && !diag1[rowNo - j + (N - 1)] && !diag2[rowNo + j - 2]) {
                // 퀸을 놓기
                col[j] = true;
                diag1[rowNo - j + (N - 1)] = true;
                diag2[rowNo + j - 2] = true;

                setQueens(rowNo + 1); // 다음 행으로 이동

                // 퀸을 제거하기
                col[j] = false;
                diag1[rowNo - j + (N - 1)] = false;
                diag2[rowNo + j - 2] = false;
            }
        }
    }
}
