import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int[][] matrix1;
	private static int[][] matrix2;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");

		int N = Integer.parseInt(split[0]); // 행렬 A의 행 수
		int M = Integer.parseInt(split[1]); // 행렬 A의 열 수 (행렬 B의 행 수)
		matrix1 = new int[N][M];

		// 행렬 A 입력
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				matrix1[i][j] = Integer.parseInt(split[j]);
			}
		}

		split = in.readLine().split(" ");
		M = Integer.parseInt(split[0]); // 행렬 B의 행 수 (행렬 A의 열 수)
		int K = Integer.parseInt(split[1]); // 행렬 B의 열 수
		matrix2 = new int[M][K];

		// 행렬 B 입력
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < K; j++) {
				matrix2[i][j] = Integer.parseInt(split[j]);
			}
		}

		int[][] matrix3 = new int[N][K]; // 결과 행렬은 N * K

		// 행렬 곱셈
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				int a = 0;
				for (int k = 0; k < M; k++) {
					a += matrix1[i][k] * matrix2[k][j];
				}
				matrix3[i][j] = a;
			}
		}
		for (int i = 0; i < matrix3.length; i++) {
			for (int j = 0; j < matrix3[0].length; j++) {
				System.out.print(matrix3[i][j]);
				if (j < matrix3[0].length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}
}