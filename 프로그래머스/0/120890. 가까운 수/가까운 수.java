class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int count = 100;
        int len = array.length;
        for (int i = 0 ; i<len;i++){
            int distance = Math.abs(array[i] - n);
            if (count > distance ||(distance == count && array[i] < answer)) {
                count = distance;
                answer = array[i];
            }
        }
        return answer;
    }
}