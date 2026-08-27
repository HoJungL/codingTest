import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] strs = myString.split("x");
        
        // 1. 빈 문자열이 아닌 것들의 개수 세기
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].isEmpty()) {
                count++;
            }
        }
        
        // 2. 정확한 크기로 새 배열 만들고 채우기
        String[] answer = new String[count];
        int idx = 0;
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].isEmpty()) {
                answer[idx++] = strs[i];
            }
        }
        
        // 3. 정렬
        Arrays.sort(answer);
        
        return answer;
    }
}