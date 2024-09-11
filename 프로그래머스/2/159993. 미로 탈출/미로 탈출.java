import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();
        int startX = -1, startY = -1;
        int leverX = -1, leverY = -1;
        int exitX = -1, exitY = -1;

        // 시작점, 레버, 출구의 위치 찾기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    leverX = i;
                    leverY = j;
                } else if (c == 'E') {
                    exitX = i;
                    exitY = j;
                }
            }
        }

        // 시작점에서 레버까지 BFS 수행
        int toLever = bfs(maps, startX, startY, leverX, leverY);
        if (toLever == -1) return -1;

        // 레버에서 출구까지 BFS 수행 (출구를 지나면서 시작점을 다시 방문 가능)
        int toExit = bfsWithStart(maps, leverX, leverY, exitX, exitY, startX, startY);
        if (toExit == -1) return -1;

        return toLever + toExit;
    }

    // BFS 수행, 시작점(S)도 다시 방문할 수 있도록 처리
    private int bfsWithStart(String[] maps, int startX, int startY, int targetX, int targetY, int initialStartX, int initialStartY) {
        int rows = maps.length;
        int cols = maps[0].length();
        visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // 목표 지점에 도착했는지 확인
                if (x == targetX && y == targetY) {
                    return steps;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (isValid(nx, ny, maps) && !visited[nx][ny]) {
                        char cell = maps[nx].charAt(ny);
                        if (cell == 'L' || cell == 'O' || cell == 'E' || (nx == initialStartX && ny == initialStartY)) {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            steps++;
        }

        return -1; // 목표 지점에 도달할 수 없는 경우
    }

    private int bfs(String[] maps, int startX, int startY, int targetX, int targetY) {
        int rows = maps.length;
        int cols = maps[0].length();
        visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // 목표 지점에 도착했는지 확인
                if (x == targetX && y == targetY) {
                    return steps;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (isValid(nx, ny, maps) && !visited[nx][ny]) {
                        char cell = maps[nx].charAt(ny);
                        if (cell == 'L' || cell == 'O' || cell == 'E') {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            steps++;
        }

        return -1; // 목표 지점에 도달할 수 없는 경우
    }

    private boolean isValid(int x, int y, String[] maps) {
        return x >= 0 && x < maps.length && y >= 0 && y < maps[0].length();
    }
}
