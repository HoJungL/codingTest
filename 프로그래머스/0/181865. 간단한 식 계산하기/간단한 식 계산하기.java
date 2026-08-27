class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] strs = binomial.split(" ");
        int first = Integer.parseInt(strs[0]);
        int second = Integer.parseInt(strs[2]);
        String cate = strs[1];
        if (cate.equals("+")){
            return first + second;
        }else if (cate.equals("-")){
            return first - second;
        }else{
            return first * second;
        }
    }
}