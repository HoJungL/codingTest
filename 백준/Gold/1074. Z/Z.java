import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int r;
	static int c;

	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		r = Integer.parseInt(split[1]);
		c = Integer.parseInt(split[2]);
		answer = 0;

		int size = (int) Math.pow(2, N);
		cut(r, c, size);
		System.out.println(answer);
	}

	private static void cut(int row, int col, int size) {
		if (size == 1) {
			return;
		}
		int half = size / 2;

		if (row < half && col < half) {
			cut(row, col, half);
		} else if (row < half && col >= half) {
			answer += size * size / 4;
			cut(row, col - half, half);
		} else if (row >= half && col < half) {
			answer += size * size / 4 * 2;
			cut(row - half, col, half);
		} else if (row >= half && col >= half) {
			answer += size * size / 4 * 3;
			cut(row - half, col - half, half);
		}

	}
}