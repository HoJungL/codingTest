import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 카드1 친구들 담을 틀
        Queue<String> queue1 = new ArrayDeque<>();
        // 카드2 친구들 담을 틀
        Queue<String> queue2 = new ArrayDeque<>();
        
        // cards1, cards2 큐에 추가
        for (String card : cards1) {
            queue1.offer(card);
        }
        for (String card : cards2) {
            queue2.offer(card);
        }
        
        // goal 배열 순서대로 확인
        for (String word : goal) {
            // 카드1친구가 안비어있고.. word가 큐의 맨 첫값(FIFO)가 같으면 빼내셈 ㅎ
            if ( word.equals(queue1.peek())) {
                queue1.poll();
            } 
            // 카드2 친구가 안비어있고, word가 큐의 맨 첫값(FIFO)가 같으면 빼내셈 ㅎ
            else if ( word.equals(queue2.peek())) {
                queue2.poll();
            } 
            // 저거 안되면... 틀린거지 뭐
            else {
                return "No";
            }
        }
        
        return "Yes";
    }
}
