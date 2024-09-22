import java.util.*;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int N = commands.length;
		int[] answer = new int[N];
		for (int m = 0; m < N; m++) {
			int i = commands[m][0] - 1;
			int j = commands[m][1];
			int k = commands[m][2] - 1;

			int[] sub = Arrays.copyOfRange(array, i, j);

			Arrays.sort(sub);

			answer[m] = sub[k];

		}
		return answer;
	}
}