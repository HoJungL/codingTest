import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();

        if (input.equals("SONGDO")) {
            System.out.println("HIGHSCHOOL");
        } else if (input.equals("CODE")) {
            System.out.println("MASTER");
        } else if (input.equals("2023")) {
            System.out.println("0611");
        } else {
            System.out.println("CONTEST");
        }
    }
}
