import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			String[] split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			int data = 1;
			for (int j = 0; j < b; j++) {
				data = data * a;
				data = data % 10;
			}
			if (data == 0) {
				data = 10;
			}
			System.out.println(data);
		}
	}
}