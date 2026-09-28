class Solution {
    public int solution(int balls, int share) {
        int r = Math.min(share, balls - share);

        long answer = 1;
        for (int i = 1; i <= r; i++) {
            answer = answer * (balls- i +1) / i;
        }

        return (int) answer;
        
    }
}