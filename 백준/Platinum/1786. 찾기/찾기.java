import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] T = in.readLine().toCharArray();
		char[] P = in.readLine().toCharArray();

		int tLen = T.length;
		int pLen = P.length;
		// 부분 일치 테이블 만들기
		int[] pi = new int[pLen];

		// i 접미사 포인터
		// j 접두사 포인터
		for (int i = 1, j = 0; i < pLen; i++) {
			while (j > 0 && P[i] != P[j]) {
				// j 이전위치 j-1 까지 일치 -> 일치했던곳 이동
				j = pi[j - 1];
			}

			// 접미사와 접두사 같으면 그 길이 부분일치 테이블에 기록
			if (P[i] == P[j]) {
				pi[i] = ++j;
			} else {
				pi[i] = 0;
			}
		}
		// 부분일치 테이블을 활용한 텍스트본문과 패턴 비교
		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		// i : 텍스트 본문 포인터
		// j : 패턴 포인터
		for (int i = 0, j = 0; i < tLen; i++) {
			while (j > 0 && T[i] != P[j]) {
				j = pi[j - 1];
			}
			// 글자 일치하면
			if (T[i] == P[j]) {
				if (j == pLen - 1) {
					cnt++;
					list.add(i-(pLen-2));
					
					j = pi[j];
				}
				else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		if (cnt>0) {
			for (int lis : list) {
				System.out.print(lis + " ");
			}
		}

	}

}