import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length - 5];
        Arrays.sort(num_list);
        int idx = 0;
        for (int i = 5; i<num_list.length; i++){
            answer[idx++] = num_list[i];
        }
        return answer;
    }
}