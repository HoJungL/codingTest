import java.util.*;
class Solution {
    public String solution(String my_string) {
        Set<Character> hash = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i =0 ; i <my_string.length();i++){
            char cha = my_string.charAt(i);
            if (!hash.contains(cha)){
                hash.add(cha);
                sb.append(cha);
            }
        }
        return sb.toString();
    }
}