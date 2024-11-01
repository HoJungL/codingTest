import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 집합 A, B의 개수
		String[] split = in.readLine().split(" ");
		// a
		int a = Integer.parseInt(split[0]);
		// b
		int b = Integer.parseInt(split[1]);

		HashSet<Integer> hashA = new HashSet<>();
		HashSet<Integer> hashB = new HashSet<>();

		// a
		split = in.readLine().split(" ");

		for (int i = 0; i < a; i++) {
			int aa = Integer.parseInt(split[i]);
			if (!hashA.contains(aa)) {
				hashA.add(aa);
			}
		}

		// b
		split = in.readLine().split(" ");

		for (int i = 0; i < b; i++) {
			int bb = Integer.parseInt(split[i]);
			if (!hashB.contains(bb)) {
				hashB.add(bb);
			}
		}
		int count = 0 ;
		HashSet<Integer> A = new HashSet<>(hashA);
		A.removeAll(hashB);
		count += A.size();
		
		HashSet<Integer> B = new HashSet<>(hashB);
		B.removeAll(hashA);
		count+= B.size();
		System.out.println(count);

	}

}