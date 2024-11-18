import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		HashMap<String, String> hash = new HashMap<String, String>();
		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			if (hash.containsKey(split[0])) {
				hash.remove(split[0]);
			} else {
				hash.put(split[0], split[1]);
			}
		}
		ArrayList<String> list = new ArrayList<>(hash.keySet());
		Collections.sort(list, Collections.reverseOrder());
		for(String li :list) {
			System.out.println(li);
		}
	}

}