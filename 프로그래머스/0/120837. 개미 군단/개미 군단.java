class Solution {
    public int solution(int hp) {
        int answer = 0;

        answer += hp / 5;
        int first = hp % 5;

        answer += first / 3;
        int second = first % 3;

        answer += second / 1;

        return answer;
    }
}