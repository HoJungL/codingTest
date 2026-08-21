class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        int index = 0 ;
        for (int i = 0 ; i<cipher.length(); i++){
            char cha = cipher.charAt(i);
            if ((index+1) % code  ==0){
                answer +=cipher.charAt(i);
            }
            index++;
        }
        return answer;
    }
}