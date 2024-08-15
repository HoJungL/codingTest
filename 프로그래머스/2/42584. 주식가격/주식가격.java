import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
		
		for (int i=0; i<answer.length; i++) {
			for (int j =i+1; j < answer.length;j++) {
				if (prices[i] <= prices[j]) {
					answer[i]++;
				}
                else{
                    answer[i]++;
                    break;
                }
			}
		}
       
        return answer;
    }
}