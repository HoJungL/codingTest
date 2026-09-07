class Solution {
    public String solution(String my_string, int s, int e) {
        String a = my_string.substring(0,s);
        String b= my_string.substring(s,e+1);
        String c= my_string.substring(e+1);
        String sb = new StringBuilder(b).reverse().toString();
        return a+sb+c;
    }
}