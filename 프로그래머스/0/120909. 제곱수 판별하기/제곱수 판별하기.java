class Solution {
    public int solution(int n) {
        int answer = 2;
        for(int i=1; i<n/2; i++){
            if(n/i == i && n%i == 0){
                answer = 1;
                break;
            }
        }
        return answer;
    }
}