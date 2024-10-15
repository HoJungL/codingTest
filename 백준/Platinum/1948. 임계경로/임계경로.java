import java.util.*;
import java.io.*;

public class Main {
    static class Edge {
        int to, time;
        Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    static int n, m;
    static List<Edge>[] adj;
    static int[] inDegree, dist;
    static List<Edge>[] reverseAdj;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 도시
        m = Integer.parseInt(br.readLine()); // 도로

        adj = new ArrayList[n + 1];
        reverseAdj = new ArrayList[n + 1];
        inDegree = new int[n + 1];
        dist = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            reverseAdj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            adj[u].add(new Edge(v, time));
            reverseAdj[v].add(new Edge(u, time)); 
            inDegree[v]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 출발 도시
        int end = Integer.parseInt(st.nextToken()); // 도착 도시

        // 최장 경로를 계산
        topol(start);

        // 도착 도시까지의 최장 경로 출력
        System.out.println(dist[end]);

        // 최장 경로에 포함된 간선의 수를 역추적하면서 카운트
        int count = countPaths(end);
        System.out.println(count);
    }

    // 위상 정렬을 이용한 최장 경로 탐색
    static void topol(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Edge edge : adj[curr]) {
                int next = edge.to;
                if (dist[next] < dist[curr] + edge.time) {
                    dist[next] = dist[curr] + edge.time;
                }
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
    // 역추적
    static int countPaths(int end) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(end);
        visited[end] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Edge edge : reverseAdj[curr]) {
                int prev = edge.to;
                // 최장 경로에 포함된 간선인 경우
                if (dist[curr] - dist[prev] == edge.time) {
                    count++;
                    if (!visited[prev]) {
                        visited[prev] = true;
                        queue.add(prev);
                    }
                }
            }
        }

        return count;
    }
}
