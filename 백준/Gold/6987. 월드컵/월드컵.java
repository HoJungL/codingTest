import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][] match;
	static boolean valid;
	static int[] win, draw, lose;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < 4; t++) {
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			match = new int[6][3]; // 각 팀의 [승, 무, 패] 정보를 저장

			String[] input = in.readLine().split(" ");
			for (int i = 0; i < 6; i++) {
				win[i] = Integer.parseInt(input[3 * i]);
				draw[i] = Integer.parseInt(input[3 * i + 1]);
				lose[i] = Integer.parseInt(input[3 * i + 2]);
			}

			valid = false;
			dfs(0, 1); // 0번 팀과 1번 팀의 경기부터 시작
			sb.append(valid ? "1 " : "0 ");
		}

		System.out.println(sb.toString().trim());

	}

	static void dfs(int a, int b) {
		if (!notNum()) {
			return;
		}

		if (valid) {
			return;
		}

		if (a == 5) { // 마지막 팀까지 검증이 끝났다면
			valid = true;
			return;
		}

		if (b == 6) {
			dfs(a + 1, a + 2);
			return;
		}

		// a팀이 b팀을 이겼을 때
		if (win[a] > 0 && lose[b] > 0) {
			win[a]--;
			lose[b]--;
			dfs(a, b + 1);
			win[a]++;
			lose[b]++;
		}

		// a팀과 b팀이 비겼을 때
		if (draw[a] > 0 && draw[b] > 0) {
			draw[a]--;
			draw[b]--;
			dfs(a, b + 1);
			draw[a]++;
			draw[b]++;
		}

		// a팀이 b팀에게 졌을 때
		if (lose[a] > 0 && win[b] > 0) {
			lose[a]--;
			win[b]--;
			dfs(a, b + 1);
			lose[a]++;
			win[b]++;
		}
	}

	private static boolean notNum() {
		for (int i = 0; i < 6; i++) {
			// 승, 무, 패의 합이 5가 되어야 함
			if (win[i] < 0 || win[i] > 5 || draw[i] < 0 || draw[i] > 5 || lose[i] < 0 || lose[i] > 5) {
				return false;
			}
		}
		return true;
	}

}