import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(in.readLine());
		for (int tc = 1; tc<=test_case ; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int lastBit = ( ( 1 << n ) ) -1;
			if (lastBit == (m &lastBit)) {
				System.out.println("#" + tc + " " + "ON");
			}else {
				System.out.println("#" + tc + " " + "OFF");
			}
		}		
	}
}