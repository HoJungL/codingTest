import java.util.*;
class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 2; i<= n; i++){
            if (n % i ==0){
                set.add(i);
                 while (n % i == 0) {
                    n /= i;
                }
            }
        }
        int[] answer = new int[set.size()];
        int index = 0 ;
        for (int num : set){
            answer[index++] = num;
        }
        return answer;
    }
}