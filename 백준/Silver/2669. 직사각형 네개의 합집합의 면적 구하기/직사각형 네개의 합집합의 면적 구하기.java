import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int[][] matrix;// 값 담을거에요.
	private static int count; // 1*1 값이 얼마나 있는지 카운트 할거에요.
	private static int x1;
	private static int y1;
	private static int x2;
	private static int y2;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		matrix = new int[100][100];
		for (int i = 0; i < 4; i++) {
			String[] split = in.readLine().split(" ");
			x1 = Integer.parseInt(split[0]);
			y1 = Integer.parseInt(split[1]);
			x2 = Integer.parseInt(split[2]);
			y2 = Integer.parseInt(split[3]);
			for (int j= x1; j<x2; j++) {
				for (int k = y1 ; k <y2 ; k++) {
					if (matrix[j][k] ==1) {
						continue;
					}else {
						matrix[j][k] =1;
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

}