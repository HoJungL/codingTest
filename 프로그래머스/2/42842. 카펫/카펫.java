class Solution {
	public int[] solution(int brown, int yellow) {
		// 격자 전체 수
		int total = brown + yellow;

		int[] answer = {0,0};

		// 둘러싸려면 최소 높이가 3이상은 되어야할거임.
		for (int height = 3; height <= total / height; height++) {
			// 전체 격자 = 높이 * 너비니까.. 전체를 높이로 나누면 너비가 딱.
			if (total % height == 0) {
				int width = total / height;
				// 둘러 쌓여있다며.. 그럼 높이, 너비 -2씩 한것들의 곱이 노란색이랑 같니..?
				if ((width - 2) * (height - 2) == yellow) {
					answer[0] = width;
					answer[1] = height;
				}
			}
		}
		return answer;
	}
}
