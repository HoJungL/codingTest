import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 데이터 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 상근이가 가지고 있는 숫자 카드의 개수 N
		int N = Integer.parseInt(in.readLine());
		// 담아주세요 헷
		HashSet<Integer> cardSet = new HashSet<>();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			cardSet.add(Integer.parseInt(st.nextToken()));
		}

		// M
		int M = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine(), " ");

		for (int i = 0; i < M; i++) {
			int card =Integer.parseInt(st.nextToken());
			
			if (cardSet.contains(card)) {
				sb.append("1 ");
			}else {
				sb.append("0 ");
			}
		}
		System.out.println(sb.toString().trim());

	}

}