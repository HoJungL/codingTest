class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int all = 0;
        int higher = 0;
        for (int i : sides ){
            all += i;
            if (i > higher){
                higher = i;
            }
        }
        all -=higher;
        if (all  <= higher){
            answer = 2;
        }else{
            answer =1;
        }
        return answer;
    }
}