
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
	public int[] solution(String s) {
		int[] answer;
		ArrayList<String> list = new ArrayList<>();
		HashMap<String, String> hashmap = new HashMap<String, String>();
		for (int i = 0; i < s.length(); i++) {
			String temp = "";
			// 튜플 집합 리스트에 저장
			if (s.charAt(i) == '{') {
				for (int j = i + 1; j < s.length(); j++) {
					// 마지막 집합까지 다 저장
					if (s.charAt(j) == '{') {
						continue;
					}
					if (s.charAt(j) == '}') {
						list.add(temp);
						break;
					}
					temp += s.charAt(j);
				}
			}
		}

		answer = new int[list.size()-1];
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {

				return o1.length() - o2.length();
			}
		});
		String[] strArr = new String[list.size()];
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			strArr = list.get(i).split(",");
			for (int j = 0; j < strArr.length; j++) {
				if (!hashmap.containsKey(strArr[j])) {
					answer[index++] = Integer.parseInt(strArr[j]);
					hashmap.put(strArr[j], strArr[j]);
					
				}
			}
		}

		return answer;
	}
}