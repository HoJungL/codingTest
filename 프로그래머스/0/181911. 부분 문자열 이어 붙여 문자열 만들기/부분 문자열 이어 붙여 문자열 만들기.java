class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        for (int i = 0 ; i <my_strings.length; i++){
            int first = parts[i][0];
            int second = parts[i][1];
            answer+= my_strings[i].substring(first,second+1);
        }
        return answer;
    }
}