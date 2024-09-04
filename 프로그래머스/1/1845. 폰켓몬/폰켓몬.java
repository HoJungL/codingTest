import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length;
        int M = N/2;
        Set<Integer> hash = new HashSet<>();
		for (int num : nums) {
			if (!hash.contains(num)) {
				hash.add(num);
			}
		}
		if (hash.size() >M) {
			answer = M;
			
		}else{
            answer = hash.size();
        }
        return answer;
    }
}