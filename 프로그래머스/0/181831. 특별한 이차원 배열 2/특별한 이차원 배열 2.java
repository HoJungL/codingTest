class Solution {
    public int solution(int[][] arr) {
        int answer = 0;
        boolean flag = true;
        for (int i = 0 ; i <arr.length;i++){
            for (int j = 0 ; j<arr.length;j++){
                if (arr[i][j] != arr[j][i]){
                    flag = false;
                }
            }
        }
        if (flag){
            return 1;
        }else{
            return 0;
        }
    }
}