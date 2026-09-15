import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String c = br.readLine();
        double a = Double.parseDouble(br.readLine());
        double b = Double.parseDouble(br.readLine());
        System.out.println(c);
        System.out.printf("%.2f",a);
        System.out.println("");
        System.out.printf("%.2f",b);
        
    }
}