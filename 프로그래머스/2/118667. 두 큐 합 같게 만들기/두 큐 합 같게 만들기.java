import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long total = 0;
        long qSum = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int i = 0 ; i< queue1.length; i++){
            total += queue1[i] + queue2[i];
            qSum += queue1[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        // 두 큐 합이 홀수면.. 같게 할수가 잇어..?
        if (total % 2 !=0){
            return -1;
        }
        // 한 큐의 값
        long target = total/2;
        while(answer <=queue1.length*3) {
            if (answer == queue1.length*3){
                return -1;
            }
			if(qSum==target){
                break;
            }
            else if(qSum>target) {
                int value = q1.poll();
				qSum-=value;
				q2.add(value);
			}else {
                int value = q2.poll();
				qSum += value;
				q1.add(value);
			}
			answer++;
		}
        return answer;
    }
}