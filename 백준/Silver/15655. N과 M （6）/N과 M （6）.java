import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int N;
	private static int M;
	private static int[] numbers;
	private static int[] list;
	private static boolean[] isSelected;

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		numbers = new int[N];

		isSelected = new boolean[N];

		split = in.readLine().split(" ");
		list= new int[split.length];
		for (int i = 0; i < split.length; i++) {
			list[i] = Integer.parseInt(split[i]);
		}
		Arrays.sort(list);
		
		combination(0,0);
		System.out.println(sb);
	}

	private static void combination(int cnt, int start) {
		// TODO Auto-generated method stub
		if (cnt == M) {
			for (int i = 0 ; i<M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start ; i<N; i++) {
			if (isSelected[i]) {
				continue;
			}
			numbers[cnt] = list[i];
			isSelected[i] = true;
			combination(cnt+1, i+1);
			isSelected[i] = false;
		}
		
	}
}