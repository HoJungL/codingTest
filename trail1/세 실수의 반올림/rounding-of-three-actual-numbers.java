import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(br.readLine());
        double b = Double.parseDouble(br.readLine());
        double c = Double.parseDouble(br.readLine());
        System.out.printf("%.3f",a);
        System.out.println();
        System.out.printf("%.3f",b);
        System.out.println();
        System.out.printf("%.3f",c);
        

    }
}