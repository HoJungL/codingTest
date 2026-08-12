class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int len = array.length;
        for (int i = 0 ; i<len; i++){
            if (array[i] == n){
                answer++;
            }
        }
        return answer;
    }
}