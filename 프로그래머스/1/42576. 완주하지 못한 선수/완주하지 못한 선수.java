import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i<completion.length; i++){
            // 완수자 수
                if (!participant[i].contains(completion[i]))
                    return participant[i];
        }
        return participant[participant.length-1];
    }
}