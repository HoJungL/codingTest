import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(in.readLine());
        int total = (1 << 10) - 1; // 모든 숫자가 등장했을때!

        for (int i = 1; i <= test_case; i++) {
            int N = Integer.parseInt(in.readLine());

            int visited = 0;
            int count = 0;
            for (count = 1; ; count++) {
                char[] arr = String.valueOf(N * count).toCharArray();
                for (char c : arr) {
                    int num = c - '0';
                    visited = visited | (1<<num);
                }
                if (visited == total) {
                    break;
                }
            }
            System.out.println("#" + i + " " + N*count);
        }

    }
}