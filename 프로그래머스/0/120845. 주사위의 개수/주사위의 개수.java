class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        int a = box[0];
        int b = box[1];
        int c = box[2];
        answer = (a / n) * (b / n) * (c/n);
        return answer;
    }
}