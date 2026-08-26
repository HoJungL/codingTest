class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int twoAB = 2 * a * b;
        String str = "" + a+b;
        answer = Integer.parseInt(str);
        if (answer >= twoAB){
            return answer;
        }
        return twoAB;
    }
}