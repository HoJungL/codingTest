import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    // 상하좌우
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    // 세로, 가로
    private static int R, C;

    // 답 출력
    private static int answer = 0;

    // 알파벳 방문 여부 (A~Z)
    private static boolean[] visited = new boolean[26];

    // 맵
    private static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = in.readLine();
            map[i] = line.toCharArray();
        }

        // DFS 시작
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count) {
        // 현재 위치의 알파벳 방문 처리
        visited[map[x][y] - 'A'] = true;

        // 최대 이동 거리 갱신
        answer = Math.max(answer, count);

        // 4방향 탐색
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[map[nx][ny] - 'A']) {
                dfs(nx, ny, count + 1);
            }
        }

        visited[map[x][y] - 'A'] = false;
    }
}