class Solution {
    public int solution(int price) {
        int answer = 0;
        int discount = 0;
        if (price >= 500000){
            discount = 20;
        }else if (price >= 300000){
            discount =10;
        }else if (price >= 100000){
            discount =5;
        }else{
            discount =0 ;
        }
        answer = price * (100 - discount) / 100;
        return answer;
    }
}