import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int[][] graph = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                Arrays.fill(graph[i], Integer.MAX_VALUE);
                graph[i][i] = 0;
            }

            // 그래프 입력
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp == 1) graph[i][j] = 1; // 간선이 있는 경우
                }
            }

            int result = Integer.MAX_VALUE;

            // 각 노드에서 다익스트라 실행
            for (int i = 1; i <= N; i++) {
                int[] dist = new int[N + 1];
                boolean[] visited = new boolean[N + 1];
                Arrays.fill(dist, Integer.MAX_VALUE);
                dist[i] = 0;

                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
                pq.offer(new int[]{i, 0}); // {노드, 거리}

                while (!pq.isEmpty()) {
                    int[] current = pq.poll();
                    int currentNode = current[0];
                    int currentDist = current[1];

                    if (visited[currentNode]) continue;
                    visited[currentNode] = true;

                    for (int nextNode = 1; nextNode <= N; nextNode++) {
                        if (graph[currentNode][nextNode] != Integer.MAX_VALUE) {
                            int newDist = currentDist + graph[currentNode][nextNode];
                            if (newDist < dist[nextNode]) {
                                dist[nextNode] = newDist;
                                pq.offer(new int[]{nextNode, newDist});
                            }
                        }
                    }
                }

                // 모든 노드까지의 거리를 합산
                int sum = 0;
                for (int j = 1; j <= N; j++) {
                    sum += dist[j];
                }
                result = Math.min(result, sum);
            }

            sb.append("#" + test_case + " " + result + "\n");
        }

        System.out.println(sb);
    }
}