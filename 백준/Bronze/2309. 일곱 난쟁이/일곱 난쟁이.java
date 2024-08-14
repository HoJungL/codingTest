import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	private static int sum;// 합
	private static int N; // 난쟁이수
	private static int[] numbers; // 난쟁이 키 담아놓을거임

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = 9;
		sum = 0;
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(in.readLine());
			numbers[i] = height;

			sum += numbers[i];
		}
		boolean flag = false;
		for (int i = 0; i < N - 1 && !flag; i++) {
			for (int j = i + 1; j < N; j++) {
				if (sum - numbers[i] - numbers[j] == 100) {
					numbers[i] = -1;
					numbers[j] = -1;
					flag = true;
					break;
				}
			}

		}
		// 이게 있었넹...
		Arrays.sort(numbers);
		for (int i = 2; i < N; i++) {
			System.out.println(numbers[i]);
		}
	}

}