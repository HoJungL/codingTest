class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int first = 0 ;
        int sec = 0;
        for (int i = 0 ; i<num_list.length;i++){
            if (i % 2 == 0){
                first += num_list[i];
            }else{
                sec += num_list[i];
            }
        }
        if (first >= sec){
            return first;
        }else{
            return sec;
        }
    }
}