import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        
        String[] strs = myStr.split("[abc]");
        
        List<String> answer = new ArrayList<>();
        for (String str : strs){
            if (!str.isEmpty()){
                answer.add(str);
            }
        }
        if (answer.isEmpty()){
            answer.add("EMPTY");
        }

        return answer.toArray(new String[0]);
    }
}