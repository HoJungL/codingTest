class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0 ; i < my_string.length(); i++){
            if (letter.charAt(0) != my_string.charAt(i)){
                answer.append(my_string.charAt(i));
            }
        }
        
        return answer.toString();
    }
}