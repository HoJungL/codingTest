import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(in.readLine());
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
                    if (tmp == 1) {
                        graph[i][j] = 1; // 간선이 있는 경우
                    }
                }
            }

            // 플로이드-워셜 알고리즘
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }

            int result = Integer.MAX_VALUE;

            // 각 노드에서의 거리 합 계산
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 1; j <= N; j++) {
                    if (graph[i][j] != Integer.MAX_VALUE) {
                        sum += graph[i][j];
                    }
                }
                result = Math.min(result, sum);
            }

            sb.append("#" + test_case + " " + result + "\n");
        }

        System.out.println(sb);
    }
}