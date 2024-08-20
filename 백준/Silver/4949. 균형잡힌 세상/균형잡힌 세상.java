import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		Stack<Character> stack = new Stack<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			// 데이터 짜르고
			String st = in.readLine();
			if (st.equals(".")) {
				return;
			}
			stack.clear(); // 매 입력마다 스택을 비워야 합니다.

			for (int i = 0; i < st.length(); i++) {
				char s = st.charAt(i);

				if (s == '(' || s == '[') {
					stack.add(s);
				} else if (s == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						stack.add(s);
					}
				} else if (s == ']') {
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						stack.add(s);
					}
				}

			}
			if (stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");

			}

		}
	}
}