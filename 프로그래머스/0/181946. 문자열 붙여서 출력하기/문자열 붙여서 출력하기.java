import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String[] parts= a.split(" ");
        
        String str1 = parts[0];
        String str2 = parts[1];
        System.out.println(str1 + str2);
    }
}