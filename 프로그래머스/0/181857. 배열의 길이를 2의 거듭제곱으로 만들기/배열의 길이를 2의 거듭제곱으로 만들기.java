class Solution {
    public int[] solution(int[] arr) {
        int count = 1;
        while( count < arr.length){
            count *=2;
        }
        
        int[] answer = new int[count];
        for (int i = 0 ; i < arr.length;i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}