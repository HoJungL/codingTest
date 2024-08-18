import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<String> hashSet = new HashSet<>();
		int count = 0;
		for (int i = 0; i < N; i++) {
			hashSet.add(in.readLine());
		}
		for (int i = 0; i<M;i++) {
			if (hashSet.contains(in.readLine())){
				count++;
			}
		}
		System.out.println(count);

	}

}