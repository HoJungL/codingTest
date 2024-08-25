import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int N;
	private static int M;
	private static int[] numbers;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		numbers = new int[M];

		combination(0, 0);
		System.out.println(sb);

	}

	private static void combination(int cnt, int start) {
		// 기저
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}

		// 유도
		for (int i = start; i < N; i++) {
			numbers[cnt] = i + 1;
			combination(cnt+1, i);
		}

	}
}