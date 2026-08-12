class Solution {
    public int solution(int n) {
        int answer = 0; 
        int first = 0;
        while (n / 10 >0){            
            // 나눈 값을 answer에 더해.
            answer += n % 10;
            // 다시 그 값을 저장해
            n = n/10;
            System.out.println(n);
            if (n <10){
                answer+= n%10;
            }
        }
        return answer;
    }
}