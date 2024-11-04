import java.util.*;
class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int [places.length];
        for (int i = 0 ;i<places.length; i++){
            String[] localHuman = places[i];
            // System.out.print(Arrays.toString(localHuman));
            boolean trueFalse = true;
            for (int r = 0; r<5 && trueFalse; r++){
                for (int c = 0 ; c<5 && trueFalse ; c++){
                    if (localHuman[r].charAt(c) =='P'){
                        if(!bfs(r,c,localHuman)){
                            trueFalse = false;
                        }
                    }
                }
            }
            if (trueFalse == true){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }

        }
        return answer;
    }
    
    public static boolean bfs(int x, int y, String[] human) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int ex = position[0];
            int ey = position[1];
            int len = Math.abs(ex - x) + Math.abs(ey - y);

            if (len > 0 && human[ex].charAt(ey) == 'P' && len <= 2) {
                return false;
            }

            if (len < 2) {
                for (int i = 0; i < 4; i++) {
                    int nx = ex + dx[i];
                    int ny = ey + dy[i];

                    if (isValue(nx, ny) && !visited[nx][ny] && human[nx].charAt(ny) != 'X') {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return true;
    }
    
    public static boolean isValue(int i, int j){
        return i>=0 && i <5 && j>=0 && j<5;
    }
}