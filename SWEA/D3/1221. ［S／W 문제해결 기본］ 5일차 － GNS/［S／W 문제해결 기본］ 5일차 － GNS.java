import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	static String[] numbers = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			// #1 7041
			String[] st = in.readLine().split(" ");
			int length = Integer.parseInt(st[1]);

			String[] nums = new String[length];
			// svn for ...
			st = in.readLine().split(" ");
			for (int i = 0; i < length; i++) {
				nums[i] = st[i];
			}
			int[] arr = new int[length];
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < numbers.length; j++) {
					if (nums[i].equals(numbers[j])) {
						arr[i] = j;
						continue;
					} else {
						continue;
					}
				}
			}
			Arrays.sort(arr);
			nums = new String[length];
			for (int i = 0; i < arr.length; i++) {
				nums[i] = numbers[arr[i]];
			}
			System.out.println(sb);
			for (String num : nums) {
				System.out.print(num + " ");
			}
		}
	}
}