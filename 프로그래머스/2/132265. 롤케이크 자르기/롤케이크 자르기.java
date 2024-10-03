import java.util.HashMap;
import java.util.HashSet;

class Solution {
	public int solution(int[] topping) {
		// 왼쪽 조각의 토핑 종류 Set
		HashSet<Integer> leftSet = new HashSet<>();
		// 오른쪽 조각의 토핑 종류 Map (토핑 번호별 개수를 저장)
		HashMap<Integer, Integer> rightMap = new HashMap<>();

		// 처음에는 모든 토핑이 오른쪽 조각에 포함되어 있다고 가정하고 카운팅
		for (int t : topping) {
			rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
		}

		int count = 0; // 공평하게 자를 수 있는 방법의 수

		// 롤케이크의 각 자를 위치를 순차적으로 검사
		for (int i = 0; i < topping.length; i++) {
			int curTopping = topping[i];

			// 현재 토핑을 왼쪽으로 옮김
			leftSet.add(curTopping);

			// 오른쪽 조각에서 해당 토핑의 개수를 줄임
			rightMap.put(curTopping, rightMap.get(curTopping) - 1);
			if (rightMap.get(curTopping) == 0) {
				rightMap.remove(curTopping);
			}

			// 왼쪽과 오른쪽의 토핑 종류 가짓수가 같다면 카운트를 증가
			if (leftSet.size() == rightMap.size()) {
				count++;
			}
		}

		return count;
	}
}
