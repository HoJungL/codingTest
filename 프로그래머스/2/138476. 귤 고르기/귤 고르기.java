import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : tangerine){
            hashMap.put(num, hashMap.getOrDefault(num,0) +1);
        }
        
        List<Integer> counts = new ArrayList<>(hashMap.values());
        Collections.sort(counts, Collections.reverseOrder());
        
        int total = 0;
        for(int count : counts){
            total+= count;
            answer++;
            if (total>=k){
                break;
            }
        }
        return answer;
    }
}