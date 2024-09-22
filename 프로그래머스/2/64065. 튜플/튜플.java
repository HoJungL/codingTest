import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	public int[] solution(String s) {
		s = s.substring(2, s.length()-2).replace("},{", " ");
		String[] sets = s.split(" ");
		
		List<Set<Integer>> list = new ArrayList<>();
		for (String set : sets) {
			Set<Integer> numSet = new HashSet<>();
			for (String num : set.split(",")) {
				numSet.add(Integer.parseInt(num));
			}
			list.add(numSet);
		}
		list.sort(Comparator.comparingInt(Set::size));
		
		List<Integer> result = new ArrayList<Integer>();
		Set<Integer> seen = new HashSet<>();
		// 작은 집합부터 차례대로 숫자를 확인하여 순서 복원
        for (Set<Integer> set : list) {
            for (int num : set) {
                if (seen.add(num)) {
                    result.add(num);
                }
            }
        }
        // 결과를 int 배열로 변환하여 answer에 저장
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        
        return answer;
	}
}