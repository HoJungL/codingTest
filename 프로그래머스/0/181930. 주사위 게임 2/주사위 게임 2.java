class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        if (a == b && a == c ){
            return (a+b+c) * (a*a+b*b+c*c) * (a*a*a + b*b*b + c*c*c);
        }else if ( ( a ==b && a !=c) || (a != b && a == c) || (a !=b) && (b==c)){
            return (a+b+c) * (a*a+b*b+c*c);
        }else{
            return a+b+c;
        }
    }
}