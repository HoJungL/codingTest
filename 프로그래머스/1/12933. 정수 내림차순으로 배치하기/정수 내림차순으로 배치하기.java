import java.util.*;

class Solution {
	public long solution(long n) {
		long answer = 0;
		String str = Long.toString(n);
		char[] chars = str.toCharArray();
		Arrays.sort(chars);

		StringBuilder sb = new StringBuilder();
		sb.append(chars);
		sb.reverse();
		answer = Long.parseLong(sb.toString());
		return answer;
	}
}