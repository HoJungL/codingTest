class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i <myString.length(); i++){
            char chr = myString.charAt(i);
            if (chr =='A'){
                sb.append('B');
            }else{
                sb.append('A');
            }
        }
        String a = sb.toString();
        System.out.println(a);
        System.out.println(pat);
        if (a.contains(pat)){
            return 1;
        }
        return 0;
    }
}