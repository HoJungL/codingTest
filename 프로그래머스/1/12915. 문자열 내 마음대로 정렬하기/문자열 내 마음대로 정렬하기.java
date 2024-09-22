import java.util.*;

class Solution {
	public String[] solution(String[] strings, int n) {
		Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// n 번째
				int result = Character.compare(o1.charAt(n), o2.charAt(n));
				if (result == 0) {
					return o1.compareTo(o2);
				}
				return result;
			}
		});
		return strings;
	}
}