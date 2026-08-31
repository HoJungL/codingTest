class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int one = intervals[0][0];
        int two = intervals[0][1];
        int three = intervals[1][0];
        int four = intervals[1][1];
        int len = (two - one) + (four - three) + 2;
        
        int[] answer = new int[len];
        int idx = 0;
        for (int i = one ; i <=two;i++){
            answer[idx++] = arr[i];
        }
        for (int i = three ; i<=four; i++){
            answer[idx++] = arr[i];
        }
        return answer;
    }
}