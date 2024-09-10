import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(in.readLine());
		// 1. 동적 테이블 만들기
		int[] D = new int[number + 1];

		// 2. 베이스 값 채우기
		D[0] = 0;
		D[1] = 0;

		for (int i = 2; i <= number; i++) {
			D[i] = D[i - 1] + 1;
			// 3으로 나누어 지면
			if (i % 3 == 0) {
				D[i] = Math.min(D[i], D[i / 3] + 1);
			}

			// 2로 나누어 지면
			if (i % 2 == 0) {
				D[i] = Math.min(D[i], D[i / 2] + 1);
			}
		}
		System.out.println(D[number]);
	}

}