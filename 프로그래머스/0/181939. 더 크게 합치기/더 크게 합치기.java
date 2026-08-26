class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        String ans1 = str1+str2;
        String ans2 = str2 + str1;
        int ans11 = Integer.parseInt(ans1);
        int ans22 = Integer.parseInt(ans2);
        
        if (ans11 >= ans22){
            return ans11;
        }
        
        return ans22;
    }
}