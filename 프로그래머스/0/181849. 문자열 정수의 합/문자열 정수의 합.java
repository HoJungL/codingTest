class Solution {
    public int solution(String num_str) {
        int answer = 0;
        for (int i =0 ; i<num_str.length();i++){
            char chr = num_str.charAt(i);
            int num = Character.getNumericValue(chr);
            answer +=num;
        }
        return answer;
    }
}