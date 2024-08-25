import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int N;
	private static int M;
	private static int[] numbers;
	private static int[] list;
	private static boolean[] isSelected;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		split = in.readLine().split(" ");
		numbers = new int[N];
		isSelected = new boolean[N];

		list = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			list[i] = Integer.parseInt(split[i]);
		}
		Arrays.sort(list);
		permutation(0);
		System.out.println(sb);

	}

	private static void permutation(int cnt) {
		// TODO 기저
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}

		// TODO 유도
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				continue;
			}
			numbers[cnt] = list[i];
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}

	}

}