class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] count = new int[31];
        for (int i = 0 ; i <strArr.length;i++){
            int a = strArr[i].length();
            count[a]++;
            answer = Math.max(answer,count[a]);
        }
        

        return answer;
    }
}