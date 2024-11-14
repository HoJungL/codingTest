import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int i = 0;
        int j = 0;

        for (;i<A.length;i++){
            for( ;j<B.length;j++){
                if (A[i]<B[j]){
                    answer++;
                    j++;
                    break;
                }
            }
        }
        return answer;
    }
}