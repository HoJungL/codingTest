class Solution {
    public String solution(int age) {
        String answer = "";
        String[] list = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String str = String.valueOf(age);
        
        for (int i = 0 ; i <str.length();i++){
            int num = str.charAt(i) - '0';
            answer += list[num];
        }
        return answer;
    }
}