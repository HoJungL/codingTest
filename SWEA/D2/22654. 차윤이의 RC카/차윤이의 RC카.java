import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static int T;
    private static int n;
    private static char[][] map;
    private static int q;
    private static String command;
    private static int[] start = { 0, 0 };
    private static int[] end = { 0, 0 };

    // 방향 배열 (오른쪽, 아래쪽, 왼쪽, 위쪽)
    private static int[] dx = { 0, 1, 0, -1 };  // 오른쪽, 아래쪽, 왼쪽, 위쪽
    private static int[] dy = { 1, 0, -1, 0 };

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            n = Integer.parseInt(in.readLine());
            map = new char[n][n];

            // 맵 정보 입력 및 시작점과 종료점 설정
            for (int i = 0; i < n; i++) {
                String line = in.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == 'X') {
                        start[0] = i;
                        start[1] = j;
                    } else if (map[i][j] == 'Y') {
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }
            q = Integer.parseInt(in.readLine());
            for (int i = 0; i < q; i++) {
                String[] split = in.readLine().split(" ");
                int commandLen = Integer.parseInt(split[0]);
                command = split[1];
                if (simulation(commandLen, command)) {
                    sb.append("1 ");
                } else {
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean simulation(int commandLen, String command) {
        int x = start[0];
        int y = start[1];
        int direction = 3; // 초기 방향: "위쪽"

        for (int i = 0; i < commandLen; i++) {
            char currentCommand = command.charAt(i);
            if (currentCommand == 'A') {
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                // 맵 범위 내에서 장애물이 없을 경우에만 이동
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] != 'T') {
                    x = nx;
                    y = ny;
                }
            } else if (currentCommand == 'L') {
                direction = (direction + 3) % 4;  // 왼쪽 회전
            } else if (currentCommand == 'R') {
                direction = (direction + 1) % 4;  // 오른쪽 회전
            }
        }

        return x == end[0] && y == end[1];
    }
}