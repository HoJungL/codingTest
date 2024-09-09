import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	static int[] parents; // 각 구역이 ㅅ어떤 선거구에 포함되었는가.
	static int[] population; // 구역의 인구수
	static int[][] adjMatrix; // 인접행렬
	static int min;
	static int N;
	static StringBuilder sb = new StringBuilder();

	// findset
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

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 첫줄은 구역수
		N = Integer.parseInt(in.readLine());

		// 두번째 줄은 각 구역의 인구수
		population = new int[N + 1];
		String[] st = in.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st[i - 1]);
		}

		adjMatrix = new int[N + 1][N + 1];
		for (int from = 1; from <= N; from++) {
			// 첫째값은 연결되어있는 개수
			st = in.readLine().split(" ");
			int cnt = Integer.parseInt(st[0]);
			// 연결된 사람들을 확인
			for (int j = 1; j <= cnt; j++) {
				int to = Integer.parseInt(st[j]);
				adjMatrix[from][to] = adjMatrix[to][from] = 1;
			}
		}
//		for(int[] ma : adjMatrix) {
//			System.out.println(Arrays.toString(ma));
//		}

		min = Integer.MAX_VALUE;

		// 부분집합 만들기
		subSet();

		if (min == Integer.MAX_VALUE) {
			sb.append(-1);
		} else {
			sb.append(min);
		}
		System.out.println(sb);
	}

	private static void subSet() {
		// 바이너리 카운팅
		// 공집합과 모든 원소를 포함한 집합을 제외한 모든 부분집합 구하기
		int caseCount = (int) Math.pow(2, N); // 2^N 대신
		for (int flag = 1; flag < (caseCount / 2); flag++) {
			// 선거구 2개로
			List<Integer> groupA = new ArrayList<>();
			List<Integer> groupB = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				if ((flag / (int) Math.pow(2, i)) % 2 == 1) { // 비트 연산 대신 나머지 연산 사용
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