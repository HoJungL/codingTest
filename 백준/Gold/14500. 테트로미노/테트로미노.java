import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int maxSum = 0;

    // 상하좌우 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 칸에서 DFS 및 T 모양 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, board[i][j], 1); // DFS로 탐색
                visited[i][j] = false;
                checkTShape(i, j); // T자 모양 탐색
            }
        }

        System.out.println(maxSum);
    }

    // DFS로 4칸짜리 테트로미노 탐색
    static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) { // 4칸을 모두 선택한 경우
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + board[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

    // T자 모양 탐색 (DFS로는 불가능한 모양)
    static void checkTShape(int x, int y) {
        // 중심점을 기준으로 4방향 중 3개를 선택하는 모양
        int[][] tShapes = {
                {0, 0, 0, -1, 0, 1, 1, 0}, // ㅗ
                {0, 0, -1, 0, 1, 0, 0, 1}, // ㅏ
                {0, 0, 0, -1, 0, 1, -1, 0}, // ㅜ
                {0, 0, -1, 0, 1, 0, 0, -1} // ㅓ
        };

        for (int[] shape : tShapes) {
            int sum = 0;
            boolean valid = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + shape[i * 2];
                int ny = y + shape[i * 2 + 1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    sum += board[nx][ny];
                } else {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }
}