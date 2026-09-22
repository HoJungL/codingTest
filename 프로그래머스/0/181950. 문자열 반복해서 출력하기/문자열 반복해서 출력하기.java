import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String str = input[0];
        int rep = Integer.parseInt(input[1]);
        System.out.println(str.repeat(rep));
    }
}
