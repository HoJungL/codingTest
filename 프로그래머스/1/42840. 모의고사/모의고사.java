import java.util.*;

class Solution {
	public int[] solution(int[] answers) {
		int[] answer = new int[3];

		int[] first = { 1, 2, 3, 4, 5 };
		int[] second = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] third = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		for (int i = 0; i < answers.length; i++) {
			if (first[i % first.length] == answers[i]) {
				answer[0]++;
			}
			if (second[i % second.length] == answers[i]) {
				answer[1]++;
			}
			if (third[i % third.length] == answers[i]) {
				answer[2]++;
			}
		}
		int max = Arrays.stream(answer).max().getAsInt();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < answer.length; i++) {
			if (max == answer[i]) {
				list.add(i + 1);
			}
		}

		int[] result = new int[list.size()];

		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}