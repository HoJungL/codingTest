class Solution {
    public int solution(int[] num_list) {
        // 모든 원소들의 곱
        int squ = 1;
        // 모든 원소들의 합 제곱
        int sumSqu = 0;
        for (int i = 0 ; i <num_list.length;i++){
            sumSqu += num_list[i];
            squ *= num_list[i];
        }
        sumSqu = sumSqu * sumSqu;
        if (squ > sumSqu){
            return 0;
        }
        return 1;
    }
}