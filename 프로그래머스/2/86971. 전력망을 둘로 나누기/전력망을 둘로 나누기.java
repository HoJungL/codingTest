import java.util.*;

class Solution {
    // 인접 리스트를 사용하여 트리 만들궁..
    List<Integer>[] tree;
    boolean[] visited;

    public int solution(int n, int[][] wires) {
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        // 드루와.. 드루와..
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            tree[v1].add(v2);
            tree[v2].add(v1);
        }
        // 최소 차이가 n이상은 안날테니 n으로 넣어주고..
        int minDiff = n; 
        
        // 각 전선을 하나씩 끊으면서 최소 차이를 계산
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            // 두 노드를 연결에서 끊음 인접리스트에서 이게 되더라구요..? 신기 그자체.
            tree[v1].remove(Integer.valueOf(v2));
            tree[v2].remove(Integer.valueOf(v1));
            
            visited = new boolean[n + 1];
            
            // v1에서 시작하여 한 쪽 서브트리 크기 계산
            int subTree = dfs(v1);
            
            // 두 서브트리의 크기 차이 계산
            int diff = Math.abs((n - subTree) - subTree);
            minDiff = Math.min(minDiff, diff);
            
            // 다시 원래 상태로 복구 안하면..ㅎ 이쁘게 틀리네..
            tree[v1].add(v2);
            tree[v2].add(v1);
        }
        
        return minDiff;
    }

    // DFS 
    private int dfs(int i) {
        visited[i] = true;
        int count = 1;
        
        for (int neighbor : tree[i]) {
            // 방문안한 부분이면  ㄱ
            if (!visited[neighbor]) {
                count += dfs(neighbor);
            }
        }
        
        return count;
    }
}
