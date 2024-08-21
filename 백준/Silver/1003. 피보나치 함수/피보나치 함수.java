import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());

		for (int i = 0 ; i<T; i++) {
			
			int[] fibo0 = new int[41];
			int[] fibo1 = new int[41];
			fibo0[0] = 1;
			fibo0[1] = 0;
			fibo1[0] = 0;
			fibo1[1] = 1;
			int n = Integer.parseInt(in.readLine());
			for (int k = 2; k<=n; k++) {
				fibo0[k] = fibo0[k-1] + fibo0[k-2];
				fibo1[k] = fibo1[k-1] + fibo1[k-2];
			}
			System.out.println(fibo0[n] + " " + fibo1[n]);
		}

	}

	

}