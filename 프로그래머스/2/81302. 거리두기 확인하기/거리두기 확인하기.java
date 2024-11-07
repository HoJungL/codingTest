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
            // 뽑아내고
            int[] position = queue.poll();
            // 움직인 위치
            int ex = position[0];
            int ey = position[1];
            // 최대 거리가 2이상이라며... 맨허튼 length
            int len = Math.abs(ex - x) + Math.abs(ey - y);

            // len이 0이상, 2이하! 그리고 사람의 현재 위치가 P이면...
            if (len > 0 && human[ex].charAt(ey) == 'P' && len <= 2) {
                return false;
            }

            if (len < 2) {
                for (int i = 0; i < 4; i++) {
                    int nx = ex + dx[i];
                    int ny = ey + dy[i];

                    // 갈수 있고!, 방문 안했고!, X가 아니면!
                    if (isValue(nx, ny) && !visited[nx][ny] && human[nx].charAt(ny) != 'X') {
                        // queue에 너어주세요
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