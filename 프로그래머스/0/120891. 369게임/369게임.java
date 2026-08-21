class Solution {
    public int solution(int order) {
        int answer = 0;
        String str  = String.valueOf(order);
        for (int i = 0 ; i <str.length(); i++){
            char cha = str.charAt(i);
            if (cha == '3' || cha =='6' || cha =='9'){
                answer++;
            }
        }
        return answer;
    }
}