public class Solution {
	public int[] solution(String s) {
		int[] answer = { 0, 0 };

		// 문자열이 "1"이 될 때까지 반복
		while (!s.equals("1")) {
			// 1. 0 제거
			int originalLength = s.length();
			s = s.replace("0", "");
			int newLength = s.length();

			// 제거된 0의 개수는 원래 길이에서 0을 제거한 후의 길이를 뺀 값
			answer[1] += originalLength - newLength;

			// 2. 길이를 2진법으로 변환
			s = Integer.toBinaryString(newLength);

			// 이진 변환 횟수 증가
			answer[0]++;
		}

		// 결과 반환: [변환 횟수, 제거된 0의 총 개수]
		return answer;
	}
}