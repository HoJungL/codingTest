import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chars = s.toCharArray();
        for (int i = 0 ; i <chars.length; i++){
            int count = 0 ;
            for (int j = 0 ; j<chars.length;j++){
                if (chars[i] == chars[j]){
                    count++;
                }
            }
            if (count ==1){
                answer += chars[i];
            }
        }
        char[] result = answer.toCharArray();
        Arrays.sort(result);
        return new String(result);
    }
}