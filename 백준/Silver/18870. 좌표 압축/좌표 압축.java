import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 좌표 개수
		int N = Integer.parseInt(in.readLine());
		// X들의 좌표
		String[] split = in.readLine().split(" ");
		
		// x 좌표 길이만큼 리스트 크기 만들고
		int[] origin = new int[split.length];
		int[] sorted = new int[split.length];
		
		//해시에 담아 일단.
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		
		for (int i = 0 ; i<N; i++) {
			// 기존의 아이
			origin[i] = Integer.parseInt(split[i]);
			// 축약한 아이
			sorted[i] = Integer.parseInt(split[i]);
		}
		// 축약한 친구 정렬 
		Arrays.sort(sorted);
		
		int rank = 0 ;
		for (int i : sorted) {
			if (!hashMap.containsKey(i)) {
				hashMap.put(i, rank);
				rank++;
//				System.out.println(hashMap);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int key : origin) {
			int rankValue = hashMap.get(key);
			sb.append(rankValue).append(" ");
		}
		System.out.println(sb);
	}
}