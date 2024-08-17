import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        
        // cards1, cards2 우선순위 큐에 추가
        for (String card : cards1) {
            queue1.offer(card);
        }
        for (String card : cards2) {
            queue2.offer(card);
        }
        
        // goal 배열 순서대로 확인
        for (String word : goal) {
            if (!queue1.isEmpty() && word.equals(queue1.peek())) {
                queue1.poll();
            } else if (!queue2.isEmpty() && word.equals(queue2.peek())) {
                queue2.poll();
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}
