import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int year = Integer.parseInt(input[2]);
        int month = Integer.parseInt(input[0]);
        int day = Integer.parseInt(input[1]);
        System.out.println(year+"."+month+"."+day);
        
    }
}