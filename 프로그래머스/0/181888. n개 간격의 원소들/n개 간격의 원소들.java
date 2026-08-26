class Solution {
    public int[] solution(int[] num_list, int n) {
        int len = (num_list.length +n-1) / n;
        int[] answer = new int[len];
        // num_list를 돌면서
        int idx = 0;
        for (int i = 0 ; i < num_list.length; i++){
            // 해당 값이 n번째 배수 값이면
            // 넣고 인덱스 추가하라.
            if (i % n ==0){
                answer[idx++] = num_list[i];
            }
        }
        return answer;
    }
}