class Solution {
    public int[] solution(String myString) {
        String[] strs = myString.split("x", -1);
        int len = strs.length ;
        int[] answer = new int[len];
        // for (String s : strs){
        //     System.out.println(s);
        // }
        for (int i = 0 ; i <len;i++){
            answer[i] = strs[i].length();
        }
        
        return answer;
    }
}