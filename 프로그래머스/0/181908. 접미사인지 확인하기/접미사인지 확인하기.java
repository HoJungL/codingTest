class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        int sufLen = is_suffix.length();
        int len = my_string.length();
        if (sufLen > len){
            return 0;
        }
        String a = my_string.substring(len - sufLen, len);
        if (is_suffix.equals(a)){
            return 1;
        }
        
        return 0;
    }
}