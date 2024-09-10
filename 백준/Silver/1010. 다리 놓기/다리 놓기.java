import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, m;
	static int[][] D;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			String[] split = in.readLine().split(" ");
			n = Integer.parseInt(split[0]);
			m = Integer.parseInt(split[1]);
			if (n < m) {
				int temp = n;
				n = m;
				m = temp;
			}
			D = new int[n + 1][m + 1];
			D[0][0] = 0;
			
			for (int j = 0 ; j<=n;j++) {
				for (int k = 0 ;k<=Math.min(j,m);k++) {
					if (k==0 || k==j) {
						D[j][k] = 1;
					}else {
						D[j][k] = D[j-1][k-1] + D[j-1][k];
					}
				}
			}
			System.out.println(D[n][m]);
		}
	}
}