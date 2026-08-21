class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String target = String.valueOf(k);
        // i부터 j 까지 k가 몇번 나오는가?
        for (int m = i ; m <=j ; m++){
            String str = String.valueOf(m);
            for (int n = 0 ; n<str.length(); n++){
                if (str.charAt(n) == target.charAt(0)){
                    answer++;
                }
            }
            
        }
        return answer;
    }
}