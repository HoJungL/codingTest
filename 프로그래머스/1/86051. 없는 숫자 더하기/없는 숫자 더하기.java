import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int answer = 0;
        
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0 ; i<numbers.length; i++){
            hashSet.add(numbers[i]);
        }
        for (int i = 0 ; i<10;i++){
            if (!hashSet.contains(i)){
                answer+= i;
            }
        }
        return answer;
    }
}