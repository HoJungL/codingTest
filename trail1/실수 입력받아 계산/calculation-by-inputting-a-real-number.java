import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(br.readLine());
        double b = Double.parseDouble(br.readLine());
        System.out.printf("%.2f", (a+b));
    }
}