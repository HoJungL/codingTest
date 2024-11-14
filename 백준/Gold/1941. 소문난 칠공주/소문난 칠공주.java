import java.io.*;
import java.util.*;

public class Main {
    static char[][] board = new char[5][5];
    static boolean[] visited = new boolean[25];
    static int answer = 0;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 5; i++) {
            String line = in.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        // 조합을 통해서 소문난 칠공주 경우의 수 탐색 시작
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int idx, int count, int sCount) {
        // 7명을 선택했을 때 조건을 만족하는지 확인
        if (count == 7) { 
            if (sCount >= 4 && isConnected()) {
                answer++;
            }
            return;
        }

        // 모든 25개 좌표를 탐색하면서 조합을 형성
        for (int i = idx; i < 25; i++) {
            int x = i / 5;
            int y = i % 5;

            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1, sCount + (board[x][y] == 'S' ? 1 : 0));
                visited[i] = false;
            }
        }
    }

    static boolean isConnected() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] checked = new boolean[25];
        
        // 선택된 좌표 중 첫 번째로 방문한 좌표를 기준으로 BFS 시작
        for (int i = 0; i < 25; i++) {
            if (visited[i]) {
                queue.add(i);
                checked[i] = true;
                break;
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            int x = current / 5;
            int y = current % 5;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int next = nx * 5 + ny;

                // 인접한 좌표가 선택된 좌표이고 아직 확인되지 않은 경우
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && visited[next] && !checked[next]) {
                    queue.add(next);
                    checked[next] = true;
                }
            }
        }
        
        // 연결된 좌표 수가 7개이면 true 반환
        return count == 7;
    }
}