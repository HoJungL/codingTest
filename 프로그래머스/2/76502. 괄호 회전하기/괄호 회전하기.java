import java.util.Stack;

class Solution {
    public int solution(String s) {
        int count = 0;
        int n = s.length();
        
        // 주어진 문자열을 n번 회전하면서 검사
        for (int i = 0; i < n; i++) {
            // 현재 회전된 문자열이 올바른지 확인
            if (isValid(s)) {
                count++;
            }
            // 문자열을 왼쪽으로 한 칸 회전
            s = s.substring(1) + s.charAt(0);
        }
        
        return count;
    }

    // 올바른 괄호 문자열인지 확인하는 함수
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}