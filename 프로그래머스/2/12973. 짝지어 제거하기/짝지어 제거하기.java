import java.util.Stack;

class Solution {
	public int solution(String s) {
		int answer = -1;
		Stack<Character> stack = new Stack<>();

		// 첫째 값 부터 넣고.
		for (int i = 0; i < s.length(); i++) {
			char cha = s.charAt(i);

			// 비어있거나, stack의 맨 위의 값이랑 cha가 다르면 넣으렴
			if (stack.isEmpty() || stack.peek() != cha) {
				stack.add(cha);
			}
			// 그게 아니라면
			else {
				stack.pop();
			}
		}
		if (stack.isEmpty()) {
			answer = 1;
		} else {
			answer = 0;
		}
		return answer;
	}
}