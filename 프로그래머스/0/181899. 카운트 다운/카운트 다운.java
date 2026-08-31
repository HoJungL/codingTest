class Solution {
    public int[] solution(int start_num, int end_num) {
        int len = start_num - end_num + 1;
        int[] answer = new int[len];
        int idx = start_num;
        for (int i = 0 ; i <len; i++){
            answer[i] = idx--;
            // if (idx == end_num)
        }
        return answer;
    }
}