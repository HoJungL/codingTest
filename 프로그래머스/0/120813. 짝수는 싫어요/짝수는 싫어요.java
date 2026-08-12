class Solution {
    public int[] solution(int n) {
        int count =0;
        for (int i = 1 ; i<=n;i++){
            if (i % 2 ==1) {
                count++;
            }
        }
        int[] answer = new int[count];
        int index = 0;
        for (int i = 1 ; i<=n;i++){
            if (i % 2 ==1) {
                answer[index++] = i;
            }
        }

        return answer;
    }
}