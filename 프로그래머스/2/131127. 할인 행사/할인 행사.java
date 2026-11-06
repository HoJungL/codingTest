import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int n = discount.length;
        int totalDays = 10;  
        int result = 0;
        
        Map<String,Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);  
        }
        
        for (int i = 0; i <= n - totalDays; i++) {
            Map<String, Integer> windowMap = new HashMap<>();
            
            for (int j = i; j < i + totalDays; j++) {
                windowMap.put(discount[j], windowMap.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean isMatch = true;  // 일치 여부를 판단하는 플래그
            for (String key : wantMap.keySet()) {
                if (windowMap.getOrDefault(key, 0) < wantMap.get(key)) {
                    isMatch = false;  // 요구사항을 충족하지 못하는 경우 isMatch를 false로 설정
                    break;  // 더 이상 체크할 필요 없이 반복문 종료
                }
            }
            if (isMatch) {
                result++;
            }
        }
        
        return result;  // 최종적으로 요구사항을 충족하는 날의 수를 반환
    }
}

