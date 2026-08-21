class Solution {
    public String solution(String letter) {
        String[] mos = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] re = letter.split(" ");
        String answer = "";

        for (int i = 0 ; i <re.length;i++){
            for (int j = 0 ; j<mos.length;j++){
                if (re[i].equals(mos[j])){
                    answer+= (char)('a' +j);
                    break;
                }
            }
        }
        return answer;
    }
}