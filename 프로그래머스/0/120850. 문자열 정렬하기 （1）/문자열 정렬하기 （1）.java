import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0 ; i <my_string.length(); i++){
            char cha = my_string.charAt(i);
            if (cha >='0' && cha <='9'){
                list.add(cha - '0');
            }
        }
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0 ; i <list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}