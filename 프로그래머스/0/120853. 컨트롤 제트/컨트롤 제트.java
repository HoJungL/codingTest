class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        int recent = 0 ;
        String[] arr = s.split(" ");
        
        for (String str : arr) {
            if (str.equals("Z")){
                answer -= recent;
            }else{
                int num = Integer.parseInt(str);
                answer += num;
                recent = num;
            }
        }

        return answer;
    }
}