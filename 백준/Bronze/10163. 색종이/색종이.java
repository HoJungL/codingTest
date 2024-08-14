import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int N; // 색종이 개수
	private static int[][] table; // 테이블

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		table = new int[1001][1001];// 최대 1001, 1001칸

		// 색종이 상하좌우
		// 색종이의 개수만큼
        // i를 1부터 시작해서 N까지 쓸건데
		for (int i = 1; i <= N; i++) {
			String[] split = in.readLine().split(" ");
			int x1 = Integer.parseInt(split[0]);
			int y1 = Integer.parseInt(split[1]);
			int x2 = Integer.parseInt(split[2]) + x1;
			int y2 = Integer.parseInt(split[3]) + y1;

			// x 범위까지
			for (int j = x1; j < x2; j++) {
				// y 범위까지
				for (int k = y1; k < y2; k++) {
                    // 앞서 i를 1부터 시작한 이유. (값이 계속 바뀔거에요.)
					table[j][k] = i;
				}
			}
		}
		int[] count = new int[N + 1];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				for (int k = 1; k <= N; k++) {
                    // 전체 돌면서, 만약 k와 같다면 count배열에 1씩 증가 시키기.
					if (table[i][j] == k) {
						count[k]++;
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(count[i]);
		}
	}

}