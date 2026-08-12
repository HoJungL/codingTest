class Solution {
    public String solution(String rsp) {
        String answer = "";
        // 0은 바위, 2는 가위, 5는 보
        // 5  //    0     // 2
        for (int i = 0 ; i <rsp.length();i++){
            char cha = rsp.charAt(i);
            if (cha=='0'){
                answer +='5';
            }else if (cha =='2'){
                answer +='0';
            }else{
                answer +='2';
            }
        }
        return answer;
    }
}