class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        for (int i = 0 ; i <queries.length;i++){
            int fir = queries[i][0];
            int sec = queries[i][1];
            int tem  = arr[fir];
            arr[fir] = arr[sec];
            arr[sec] = tem;
        }
        return arr;
    }
}