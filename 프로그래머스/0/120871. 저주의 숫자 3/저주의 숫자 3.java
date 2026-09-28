class Solution {
    public int solution(int n) {
        int num = 0 ;
        for (int i = 0 ;i <n; i++){
            num++;

            while (num % 3 ==0 || Integer.toString(num).contains("3")){
                num++;
            }
        }
        return num;
    }
}