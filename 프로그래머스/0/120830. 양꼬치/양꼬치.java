class Solution {
    public int solution(int n, int k) {
        // n은 양꼬치, k는 음료수
        // 양꼬치 12,000원 음료수 2,000원. 단, 10인분 에 음료수 1개 서비스
        int answer = 0;
        
        int first = n * 12000;
        int service = n / 10;
        int second = (k - service) * 2000;
        answer = first + second;

        return answer;
    }
}