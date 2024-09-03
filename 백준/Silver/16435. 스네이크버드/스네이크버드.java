import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	// 과일 개수
	private static int fruit;
	// 스네이크 길이
	private static int snake;

	// 과일 개수에 따른 리스트 (높이)
	private static int[] height;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		fruit = Integer.parseInt(split[0]);
		snake = Integer.parseInt(split[1]);
		height = new int[fruit];
		split = in.readLine().split(" ");
		// 데이터 담고
		for (int i = 0; i < fruit; i++) {
			height[i] = Integer.parseInt(split[i]);
		}
		// 정렬하고
		Arrays.sort(height);
		for (int i = 0 ; i<height.length; i++) {
			if (snake >= height[i]) {
				snake++;
			}else {
				break;
			}
		}
		System.out.println(snake);

	}

}