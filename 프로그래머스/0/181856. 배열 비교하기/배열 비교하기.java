class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        int arr1len = arr1.length;
        int arr2len = arr2.length;
        int sum1 = 0 ;
        int sum2 = 0 ;
        // 배열 길이 비교 부터
        if (arr1len > arr2len){
            return 1;
        }else if (arr1len < arr2len){
            return -1;
        }
        // 배열 길이가 같다면
        for (int i = 0 ; i <arr1len;i++){
            sum1 += arr1[i];
            sum2 += arr2[i];
        }
        if (sum1 > sum2){
            return 1;
        }else if (sum1 < sum2){
            return -1;
        }
        return 0;
    }
}