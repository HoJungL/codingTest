class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        // 문자열 길이 확인

        if (s.length() == 4 || s.length() == 6){
            System.out.println(s);

            for (int i = 0 ; i <s.length();i++){
                char cha = s.charAt(i);
                if (!Character.isDigit(cha)){
                    answer = false;
                }
            }
        }else{
            answer =false;
        }
        return answer;
    }
}