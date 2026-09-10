import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double answer = Double.parseDouble(br.readLine()) +1.5;
        System.out.printf("%.2f", answer);

    }
}