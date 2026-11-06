import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i<progresses.length;i++){
            int day = (100- progresses[i] +speeds[i] -1) / speeds[i];
            queue.add(day);
        }
        while(!queue.isEmpty()){
            int deployDay = queue.poll();
            int count = 1;
            
            while(!queue.isEmpty() && (queue.peek() <= deployDay)){
                queue.poll();
                count++;
            }
        
        
            
            result.add(count);
        }


        // 2. 배포 그룹 계산


        // 3. List를 배열로 변환
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}