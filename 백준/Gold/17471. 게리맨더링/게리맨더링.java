import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	// findSet
	static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	// union
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}

	static int[] parents;
	static int[] population;
	static int[][] adjMatrix;
	static int min;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 구역 수
		N = Integer.parseInt(in.readLine());
		// 인구수
		String[] split = in.readLine().split(" ");
		population = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(split[i - 1]);
		}

		adjMatrix = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			split = in.readLine().split(" ");
			// 구역별 연결되어있는 구역 수 (2, 2, 4 면 2개 카운트
			int cnt = Integer.parseInt(split[0]);
			for (int j = 1; j <= cnt; j++) {
				int to = Integer.parseInt(split[j]);
				adjMatrix[i][to] = adjMatrix[to][i] = 1;
			}
		}
		min = Integer.MAX_VALUE;
		subset();

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}

	private static void subset() {
		int count = (int) Math.pow(2, N);
		for (int flag = 1; flag < (count / 2); flag++) {
			List<Integer> groupA = new ArrayList<>();
			List<Integer> groupB = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				if ((flag / (int) Math.pow(2, i)) % 2 == 1) {
					groupA.add(i + 1);
				} else {
					groupB.add(i + 1);
				}
			}

			parents = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				parents[i] = i;
			}
			for (int i = 0; i < groupA.size() - 1; i++) {
				for (int j = i + 1; j < groupA.size(); j++) {
					int from = groupA.get(i);
					int to = groupA.get(j);
					if (adjMatrix[from][to] == 1) {
						union(from, to);
					}
				}
			}

			for (int i = 0; i < groupB.size() - 1; i++) {
				for (int j = i + 1; j < groupB.size(); j++) {
					int from = groupB.get(i);
					int to = groupB.get(j);
					if (adjMatrix[from][to] == 1) {
						union(from, to);
					}
				}
			}
			
			for (int i = 0; i <= N; i++) {
				findSet(i);
			}

			Arrays.sort(parents);
			int cntParents = 0;

			for (int i = 0; i < parents.length - 1; i++) {
				if (parents[i] != parents[i + 1]) {
					cntParents++;
				}
			}
			if (cntParents == 2) {
				int cntA = 0;
				int cntB = 0;
				for (int i = 0; i < groupA.size(); i++) {
					int zone = groupA.get(i);
					cntA += population[zone];
				}
				for (int i = 0; i < groupB.size(); i++) {
					int zone = groupB.get(i);
					cntB += population[zone];
				}
				min = Math.min(min, Math.abs(cntA - cntB));
			}
		}
	}
}