class Solution {
    public int[] solution(int[] numbers, String direction) {
        int len = numbers.length;
        int[] answer = new int[len];
        int value = 0;
        if (direction.equals("right")){
            value = numbers[len-1];
            for (int i = len-1 ; i >0 ; i--){
                answer[i] = numbers[i-1];
            }
            answer[0] =value;
        }
        if (direction.equals("left")){
            value = numbers[0];
            for (int i = 0; i<len-1;i++){
                answer[i] = numbers[i+1];
            }
            answer[len-1] = value;
        }
        
        return answer;
    }
}