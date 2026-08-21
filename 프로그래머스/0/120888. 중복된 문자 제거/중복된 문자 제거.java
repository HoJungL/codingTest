class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] chars = my_string.toCharArray();
        for (int i = 0 ; i <chars.length;i++){
            if (!answer.contains(String.valueOf(chars[i]))){
                answer+=chars[i];
            }
        }
        return answer;
    }
}