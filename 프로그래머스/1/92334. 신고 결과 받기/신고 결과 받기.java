import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> hash = new HashMap<>();
		HashMap<String, Integer> idx = new HashMap<>();
		for (int i = 0; i < id_list.length; i++) {
			String name = id_list[i];
			hash.put(name, new HashSet<>());
			idx.put(name, i);
		}
		for (String re : report) {
			String[] split = re.split(" ");
			String key = split[0];
			String value = split[1];

			hash.get(value).add(key);
		}
		for (int i = 0; i < id_list.length; i++) {
			HashSet<String> send = hash.get(id_list[i]);
			if (send.size() >= k) {
				for (String name : send) {
					answer[idx.get(name)]++;
				}
			}
		}
        return answer;
    }
}