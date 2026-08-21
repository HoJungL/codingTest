class Solution {
    public int solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        
        for (int i = 0 ; i <my_string.length();i++){
            char ch = my_string.charAt(i);
            if (Character.isDigit(ch)){
                sb.append(ch);
            }else{
                if (sb.length()>0){
                    answer += Integer.parseInt(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if (sb.length() >0){
            answer+= Integer.parseInt(sb.toString());
        }
        return answer;
    }
}