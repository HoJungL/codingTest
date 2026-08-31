class Solution {
    public int[] solution(int n, int k) {
        int len = n / k;
        int[] answer = new int[len];
        int idx = 0;
        for (int i = 1; i<=len ; i++){
            answer[idx++] = k * i;
        }
        return answer;
    }
}