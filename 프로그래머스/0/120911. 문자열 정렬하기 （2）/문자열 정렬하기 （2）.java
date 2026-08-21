import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        my_string = my_string.toLowerCase();
        char[] chars = my_string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}