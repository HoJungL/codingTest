class Solution {
    public String solution(String my_string, int m, int c) {
        int len = my_string.length() / m ;
        String answer = "";
        for (int i = 0 ; i < len; i++){
            answer += my_string.charAt(i * m + (c-1));
        }
        return answer;
    }
}