class Solution {
    public int solution(int n, String control) {
        // charAt으로 하나씩 때자
        for (int i = 0 ; i <control.length();i++){
            char chr = control.charAt(i);
            if (chr == 'w') {
                n +=1;
            }else if (chr =='s'){
                n -=1;
            }else if (chr =='d'){
                n +=10;
            }else{
                n -=10;
            }
        }
        return n;
    }
}