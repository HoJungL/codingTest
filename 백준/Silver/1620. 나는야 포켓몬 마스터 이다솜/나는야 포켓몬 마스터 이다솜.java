import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	// 포켓몬수, 문제 개수
	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		HashMap<Integer, String> map = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		
		// 데이터 넣공
		for (int i = 0; i < N; i++) {
			String word = in.readLine();
			map.put(i+1, word);
			map2.put(word, i+1);
		}
		for (int i = 0; i < M; i++) {
			String answer = in.readLine();
			// 문자를 가지고 있으면. -> 숫자를 가져와야징.
			if (map2.containsKey(answer)) {
				System.out.println(map2.get(answer));
			} else {
				System.out.println(map.get(Integer.parseInt(answer)));
			}
		}
	}
}