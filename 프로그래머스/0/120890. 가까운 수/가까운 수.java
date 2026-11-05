class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;

        // 최솟값이라고 가정
        int num = array[0];
        // 가장 작은값인지 기록하기 위한 수치 저장소
        int count1 = Math.abs(n-array[0]);
        for (int i = 0 ; i <array.length;i++){
            
            // 거리 수치
            int count2 = Math.abs(n-array[i]);
            
            if (count1 > count2){
                count1 = count2;
                                num = array[i];

            }
            
            if (count1 ==count2 && num> array[i]){
                num = array[i];
            }
        }
        return num;
    }
}