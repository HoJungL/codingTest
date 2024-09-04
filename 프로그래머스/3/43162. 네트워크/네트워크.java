import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
public int solution(int n, int[][] computers) {
		int answer = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				queue.add(i);
				visited[i] = true;
				answer++;
			}

			while (!queue.isEmpty()) {
				int a = queue.poll();

				for (int j = 0; j < n; j++) {
					if (computers[a][j] == 1 && !visited[j]) {
						visited[j] = true;
						queue.add(j);
					}

				}
			}
		}

		return answer;
	}

}