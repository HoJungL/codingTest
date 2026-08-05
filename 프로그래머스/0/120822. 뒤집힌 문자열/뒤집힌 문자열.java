class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuffer stb = new StringBuffer(my_string);
        answer = stb.reverse().toString();
        return answer;
    }
}