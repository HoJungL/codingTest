import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        // s가 길이가 0일때. 
        if (s.length() == 0){
            return true;
        }
        for (int i = 0 ; i <s.length(); i++){
            // '('가 들어오는건 모두 받음
            if (s.charAt(i) =='('){
                stack.add(s.charAt(i));
            }
            // 처음부터 ')' 들어오면
            // 비어있는 상태에서 ')'가 먼저 들어올경우
            if (stack.isEmpty() && s.charAt(i) ==')' ){
                return false;
            }

            // ')'일때, 
            if (!stack.isEmpty() && s.charAt(i) == ')'){
                    stack.pop();
            }
        }
        if (stack.isEmpty() == true){
            answer = true;
        }else{
            answer =false;
        }

        return answer;
    }
}