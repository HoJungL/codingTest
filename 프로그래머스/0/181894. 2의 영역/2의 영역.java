class Solution {
    public int[] solution(int[] arr) {
        boolean[] bool = new boolean[arr.length];
        for (int i = 0 ; i <arr.length;i++){
            if (arr[i] == 2){
                bool[i] = true;
            }
        }
        boolean flag = false;
        int first = 0;
        int second = 0;
        for (int i = 0 ; i<arr.length;i++){
            // 가장 처음에 나오는 숫자 2
            if (arr[i] ==2){
            if (!flag){
                first = i;
                flag = true;
            }else if (flag == true){
                second = i;
            }           
        }
        }
        if (flag == false){
            return new int[]{-1};
        }
        if (second == 0){
            return new int[]{2};
        }
        int[] answer = new int[second - first +1];
        int idx = 0;
        for (int i = first ; i <= second; i++){
            answer[idx++] = arr[i];
        }
        
        
        return answer;
    }
}