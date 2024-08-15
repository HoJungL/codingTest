import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        // 가격을 순회하면서 처리
        for (int i = 0; i < n; i++) {
            // 현재 가격보다 작은 가격이 스택의 상단에 있다면,
            // 그 가격은 현재 가격이 끝날 때까지 유지되지 않으므로,
            // 스택에서 꺼내고 그 가격의 기간을 계산
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            // 현재 인덱스를 스택에 추가
            stack.push(i);
        }

        // 스택에 남아 있는 인덱스는 끝까지 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = n - index - 1;
        }

        return answer;
    }
}
