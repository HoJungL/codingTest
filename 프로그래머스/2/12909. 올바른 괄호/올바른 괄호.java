import java.util.Stack;

class Solution {
	boolean solution(String s) {
		boolean answer = true;

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char cha = s.charAt(i);
			if (cha == '(') {
				stack.add(cha);
			} else if (cha == ')') {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			answer = true;
		} else {
			answer = false;
		}
		return answer;
	}
}
