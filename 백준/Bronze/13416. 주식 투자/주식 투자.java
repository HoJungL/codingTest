import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] A;
	private static int[] B;
	private static int[] C;

	public static void main(String[] args) throws Exception {

		// 데이터 받기 위해서 버퍼드 리더
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 테케 개수 받고
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			// 일수 입력 받고
			int N = Integer.parseInt(in.readLine());
			A = new int[N];
			B = new int[N];
			C = new int[N];

			// 합 값
			int sum = 0;
			// 데이터 넣고
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");

				A[j] = Integer.parseInt(st.nextToken());
				B[j] = Integer.parseInt(st.nextToken());
				C[j] = Integer.parseInt(st.nextToken());
			}
			// 비교를 실행합니다.
			for (int k = 0; k < N; k++) {
				// 모든 값이 0이하일 경우
				if (A[k] <= 0 && B[k] <= 0 && C[k] <= 0) {
					continue;
				}
				// 0 이상이 1개 이상 있을 경우
				else if (A[k] >= 0 || B[k] >= 0 || C[k] >= 0) {
					sum += Math.max(Math.max(A[k], B[k]), C[k]);
				}
			}
			System.out.println(sum);

		}

	}

}