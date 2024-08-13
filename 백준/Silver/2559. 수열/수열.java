import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int N; // 온도를 측정한 전체 날짜의 수
	private static int K; // 합을 구하기 위한 연속적인 날짜의 수
	private static int[] temp; // 숫자로 변환하기 위한 변수
	private static int[] Calsum; // 합 구하기

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		K = Integer.parseInt(split[1]);

		temp = new int[N];

		// 입력값 받기
		String[] split2 = in.readLine().split(" ");
		// 값 담아 놓기
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(split2[i]);
		}

		// 첫 K일의 합을 구함
		int currentSum = 0;
		for (int i = 0; i < K; i++) {
			currentSum += temp[i];
		}

		int maxSum = currentSum;

		// 슬라이딩 윈도우로 최대합을 구함
		for (int i = K; i < N; i++) {
			// 이전 합에서 첫 번째 날의 값을 빼고, 새로운 날의 값을 더함
			currentSum = currentSum - temp[i - K] + temp[i];
			// 최대합 갱신
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
		}
		System.out.println(maxSum);

	}

}