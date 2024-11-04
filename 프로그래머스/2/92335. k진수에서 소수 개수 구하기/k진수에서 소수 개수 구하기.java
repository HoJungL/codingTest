class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String number = Long.toString(n,k);
        String[] arrays = number.split("0");
        
        for (String a : arrays){
            if (a.isEmpty() || a.isBlank()){
                continue;
            }
            if (isPrime(Long.parseLong(a))){
                answer++;
            }
        }
        return answer;
    }
        
        public boolean isPrime(Long n) {
        if (n == 1) return false;
        if (n == 2) return true;
                
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}