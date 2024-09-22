import java.util.*;

class Solution {
	public String solution(int[] numbers) {

		String[] strNumbers = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			strNumbers[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(strNumbers, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (String str : strNumbers) {
			sb.append(str);
		}
		if (sb.charAt(0)=='0') {
			return "0";
		}
		return sb.toString();
	}
}