class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() == 4 || s.length() ==6){
            for (int i = 0 ; i<s.length();i++){
                char cha = s.charAt(i);
                if (Character.isDigit(cha)){
                    continue;
                }else{
                    answer = false;
                }
            }
        }else{
            answer = false;
        }
        return answer;
    }
}