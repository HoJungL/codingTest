class Solution {
    public int[] solution(int[] arr) {
        
        int count = 0;
        
        for (int i = 0 ; i < arr.length;i++){
            count += arr[i];
        }
        
        int[] answer = new int[count];
        int idx = 0;
        for (int i = 0 ; i <arr.length;i++){
            int num = arr[i];
            for (int j = 0 ; j <num; j++){
                answer[idx] = num;
                idx++;
            }
        }
        return answer;
    }
}