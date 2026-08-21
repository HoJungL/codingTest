class Solution {
    public int solution(int n) {
        int answer = 1;
        int facto = 1;
        while (facto <= n){
            answer++;
            facto *= answer;
            
        }
        return answer-1;
    }
}