class Solution {
    public int[] solution(int[][] score) {
        int[] avg = new int[score.length];
        int[] fir = new int[avg.length];
        
        for (int i = 0 ; i <score.length;i++){
            avg[i] = (score[i][0] + score[i][1]);

        }
        
        for (int i = 0 ; i <fir.length;i++){
            fir[i]= 1;
            for (int j = 0 ; j<fir.length;j++){
                if (avg[i] < avg[j]){
                    fir[i]++;
                }
            }
        }
        return fir;
    }
}