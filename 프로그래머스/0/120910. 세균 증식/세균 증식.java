class Solution {
    public int solution(int n, int t) {
        int answer = 0;
        
        // 2배..
        for (int i = 0 ; i<t;i++){
           n *=2;
        }
        answer = n;
        return answer;
    }
}