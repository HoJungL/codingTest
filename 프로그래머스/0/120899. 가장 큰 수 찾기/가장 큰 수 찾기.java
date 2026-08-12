class Solution {
    public int[] solution(int[] array) {
        int index = 0;
        int[] answer = new int[2];
        int first = 0;
        for (int i = 0 ; i<array.length;i++){
            if (first < array[i]){
                first = array[i];
                index = i;
            }
        }
        answer[0] = first;
        answer[1] = index;
        return answer;
    }
}