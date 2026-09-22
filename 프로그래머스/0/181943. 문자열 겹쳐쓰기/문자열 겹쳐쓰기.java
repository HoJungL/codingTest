
import java.io.*;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i <my_string.length();i++){
            sb.append(my_string.charAt(i));
        }
        sb.replace(s, overwrite_string.length()+s, overwrite_string);
        return sb.toString();
    }
}
