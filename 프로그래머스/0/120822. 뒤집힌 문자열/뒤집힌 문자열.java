class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i <my_string.length();i++){
            sb.append( my_string.charAt(i));
        }
        sb = sb.reverse();
        return sb.toString();
    }
}