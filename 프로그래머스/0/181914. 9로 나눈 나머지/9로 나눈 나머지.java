class Solution {
    public int solution(String number) {
        int answer = 0;
        int num = 0;
        for (int i = 0 ; i< number.length();i++){
            num += number.charAt(i) -'0';
        }
        System.out.println(num);
        answer = num % 9 ;
        return answer;
    }
}