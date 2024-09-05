import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class Main {

    private static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static int maxSafe = 1;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1}; // dy[3]을 1에서 -1로 변경

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        matrix = new int[N][N];
        visited = new boolean[N][N];
        HashSet<Integer> heights = new HashSet<>();
        
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            String[] split = in.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
                heights.add(matrix[i][j]);
                if (matrix[i][j] > maxHeight) {
                    maxHeight = matrix[i][j];
                }
            }
        }

        for (int rain : heights) {
            visited = new boolean[N][N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] >= rain && !visited[i][j]) {
                        bfs(i, j, rain);
                        count++;
                    }
                }
            }

            if (count > maxSafe) {
                maxSafe = count;
            }
        }

        System.out.println(maxSafe);
    }

    private static void bfs(int i, int j, int rain) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (isValid(nx, ny) && matrix[nx][ny] >= rain && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }

    private static boolean isValid(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }
}