import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			String[] values = in.readLine().split(" ");
			int count = Integer.parseInt(values[0]);
			int[] list = new int[count];
			int sum = 0;
			for (int j = 0; j < count; j++) {
				list[j] = Integer.parseInt(values[j + 1]);
				sum += list[j];
			}
			// 평균
			double avg = (double) sum / count;
			int student = 0;
			for (int li : list) {
				if (li > avg) {
					student++;
				}
			}
			double result = (double) student / count * 100;
			String resultS = String.format("%.3f", result);
			System.out.println(resultS + "%");
		}
	}
}