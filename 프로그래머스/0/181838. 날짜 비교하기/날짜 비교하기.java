class Solution {
    public int solution(int[] date1, int[] date2) {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i <date1.length;i++){
            sb1.append(date1[i]);
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i <date2.length;i++){
            sb2.append(date2[i]);
        }
        int dateF = Integer.parseInt(sb1.toString());
        int dateS = Integer.parseInt(sb2.toString());
        if (dateF < dateS){
            return 1;
        }else{
            return 0;
        }

    }
}