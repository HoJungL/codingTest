import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	private static int T; // 테스트 케이스 개수
	private static int n; // n개의 집합 (필요없는거 같은데..)
	private static int m; // 입력으로 주어지는 연산의 개수
	private static int[] parents; // 리스트 담을거임 ㅎ

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			String[] split = in.readLine().split(" ");
			n = Integer.parseInt(split[0]);
			m = Integer.parseInt(split[1]);
			makeSet();

			for (int i = 0; i < m; i++) {
				split = in.readLine().split(" ");
				// 0인가 1인가 파악
				int type = Integer.parseInt(split[0]);
				// 대표자
				int a = Integer.parseInt(split[1])-1;
				// 자식.
				int b = Integer.parseInt(split[2])-1 ;

				if (type == 0) {
					union(a, b);
				} else if (type == 1) {
					if (findSet(a) == findSet(b)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
				}
			}
			sb.append("\n");

		}

		System.out.println(sb);

	}

	private static void makeSet() {

		// 정점 번호 0번부터 시작
		parents = new int[n];

		// 자신의 대표자를 자신의 정점 번호로 설정 -> 내가 대표임 빼액!!
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

	}

	private static int findSet(int a) {

		// 정점 번호랑 대표자 번호가 같으면 지 스스로를 호출하세유
		if (parents[a] == a) {
			return a;
		}
		// 아니면 parents[a]의 대표자를 찾아..!! 찾으라고!!
//		return findSet(parents[a]);
		return parents[a] = findSet(parents[a]); // path compression
	}

	// a,b 두 집합을 합치는거야!!
	// 근데, a가 대표자가 아닐수도 있겠지??
	// 그렇게 되면 a의 대표자가 a를 몰고와서 한꺼번에 합쳐지는거란다!!
	private static boolean union(int a, int b) {

		int aRoot = findSet(a);
		int bRoot = findSet(b);

		// 이미 a정점과 b 정점이 같은 집합이면 false를 던지셈
		if (aRoot == bRoot) {
			return false;
		}
		// A가 새로운 집합의 대표자로 선정
		// 값이 대표자인거임.
		parents[bRoot] = aRoot;
		return true;
	}
}