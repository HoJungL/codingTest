class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int len = array.length;
        for (int i = 0 ;  i<len; i++){
            String str = String.valueOf(array[i]);
            for (int j = 0 ; j<str.length(); j++){
                if (str.charAt(j) =='7'){
                    answer++;
                }
            }
        }
        return answer;
    }
}