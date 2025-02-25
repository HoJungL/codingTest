import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int vertex;
        int weight;
        Node next;
        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }
    
    private static class Pair implements Comparable<Pair> {
        int vertex, distance;
        public Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
    
    private static final int INF = Integer.MAX_VALUE;
    private static int V, E;
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        int start = Integer.parseInt(in.readLine());
        Node[] adjList = new Node[V + 1];
        
        // 인접리스트 생성 (각 정점에 대해 연결리스트 형태)
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            // head 삽입
            adjList[from] = new Node(to, weight, adjList[from]);
        }
        
        int[] distance = new int[V + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        
        // 우선순위 큐를 이용한 다익스트라 알고리즘
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(start, 0));
        
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;
            
            // 이미 더 짧은 경로가 발견된 경우 스킵
            if (current.distance > distance[u]) continue;
            
            for (Node temp = adjList[u]; temp != null; temp = temp.next) {
                int v = temp.vertex;
                int newDist = distance[u] + temp.weight;
                if (newDist < distance[v]) {
                    distance[v] = newDist;
                    pq.offer(new Pair(v, newDist));
                }
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
        }
        System.out.print(sb);
    }
}