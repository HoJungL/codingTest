import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");

		long sum = 0; // 모든 x_i의 합
		long squareSum = 0; // 모든 x_i^2의 합

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(split[i]);
			sum += x;
			squareSum += (long) x * x;
		}

		// 결과 계산: (sum^2 - squareSum) / 2
		long result = (sum * sum - squareSum) / 2;

		System.out.println(result);
	}
}