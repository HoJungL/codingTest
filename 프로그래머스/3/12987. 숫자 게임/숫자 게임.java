import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int b : B) {
            queue.add(b);
        }
        for (int i = 0; i < A.length; i++) {
            while (!queue.isEmpty() && queue.peek() <= A[i]) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                queue.poll();
                answer++;
            }
        }
        return answer;
    }
}