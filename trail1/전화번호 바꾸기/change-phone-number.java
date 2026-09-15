import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        System.out.println(input[0]+"-"+c+"-"+b);
        
    }
}