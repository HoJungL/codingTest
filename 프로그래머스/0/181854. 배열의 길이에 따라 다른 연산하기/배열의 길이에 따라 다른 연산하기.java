class Solution {
    public int[] solution(int[] arr, int n) {
        int len = arr.length;
        int[] answer = new int[len];
        // 배열 길이 홀수
        if (len %2 ==1){
            for (int i = 0 ; i <len ; i ++){
                if (i % 2 == 0 ){
                    answer[i]  = arr[i] +n;
                }else{
                    answer[i] = arr[i];
                }
            }    
        }
        // 배열 길이 짝수
        if (len %2 ==0){
            for (int i = 0 ; i <len ; i ++){
                if (i % 2 == 1){
                    answer[i]  = arr[i] +n;
                }else{
                    answer[i] = arr[i];
                }
            }    
        }
        return answer;
    }
}