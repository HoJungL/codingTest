
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int N ;
	static int M ;
    static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };    
    static int[][] maps1;

    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        maps1 = maps;
		visited = new boolean[N][M];
		
		if (maps1[0][0] == 0 || maps1[N-1][M-1] == 0) {
            return -1;
        }
        answer = bfs(0,0);

        return answer;
    }
    private static int bfs(int i, int j) {
		// TODO Auto-generated method stub
        Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] a = queue.poll();
			int ex = a[0];
			int ey = a[1];
			
			if (ex == N-1 && ey == M-1) {
				return maps1[ex][ey];
			}
			for (int k = 0; k < 4; k++) {
				int nx = ex + dx[k];
				int ny = ey + dy[k];
		
					if (isTrue(nx, ny) && maps1[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						maps1[nx][ny] = maps1[ex][ey] + 1;
						queue.add(new int[] {nx,ny});
                        
                    }
                }
            }
        
        return -1;
    }

	private static boolean isTrue(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}
}