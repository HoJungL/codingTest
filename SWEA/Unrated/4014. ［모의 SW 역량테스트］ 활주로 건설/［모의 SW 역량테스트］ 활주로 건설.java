import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWIeW7FakkUDFAVH&solveclubId=AZB7Z7Y6vHYDFASB&problemBoxTitle=17%EC%9D%BC%EC%B0%A8&problemBoxCnt=3&probBoxId=AZHjjKdKgHoDFAXd
public class Solution {
	static int T, n, x;
	static int[][] matrix;
	static int count;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			String[] split = in.readLine().split(" ");
			n = Integer.parseInt(split[0]);
			x = Integer.parseInt(split[1]);

			matrix = new int[n][n];
			count = 0;
			for (int i = 0; i < n; i++) {
				split = in.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(split[j]);
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == 0) {
						row(i, j);
					}
					if (j == 0) {
						col(i, j);
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);

	}

	private static void row(int r, int c) {
		int len = 1;
		int height = matrix[r][c];

		if (r == 0) {
			for (int i = 1; i < n; i++) {
				// 높이 같을때
				if (height - matrix[i][c] == 0) {
					len++;
				}
				// 다음 지점의 높이가 1작으면
				else if (height - matrix[i][c] == 1) {
					// x(활주로의 x 길이)가 더 길면... 이후처리는 x
					if (n - i < x) {
						return;
					}
					// x가 더짧으면 다시 확인해서...
					else {
						for (int j = 1; j < x; j++) {
							// 
							if (height - matrix[++i][c] != 1) {
								return;
							}
						}
						// 높이는 바꿔주고
						height = matrix[i][c];
						// 길이 초기화하고
						len = 0;
					}
					
				}
				// 다음 지점의 높이가 1 높으면
				else if (height - matrix[i][c] == -1) {
					// 경사로 설치 가능하면
					if (len >= x) {
						height = matrix[i][c];
						len = 1;
					} else {
						return;
					}
				} 
				// 2이상 차이나면 설치 안되니까 ㅃㅃ
				else {
					return;
				}
			}
			// 전체 for문 돌때마다 카운트 1 더해주면 확인 된거니까 1개씩 올라가요
			count++;
		}
	}

	private static void col(int r, int c) {

		int len = 1;
		int height = matrix[r][c];

		if (c == 0) {
			for (int i = 1; i < n; i++) {
				if (height - matrix[r][i] == 0) {
					len++;
				} else if (height - matrix[r][i] == 1) {
					if (n - i < x) {
						return;
					} else {
						for (int j = 1; j < x; j++) {
							if (height - matrix[r][++i] != 1) {
								return;
							}
						}
						height = matrix[r][i];
						len = 0;
					}
				} else if (height - matrix[r][i] == -1) {
					if (len >= x) {
						height = matrix[r][i];
						len = 1;
					} else {
						return;
					}
				} else {
					return;
				}
			}
			count++;
		}

	}

}