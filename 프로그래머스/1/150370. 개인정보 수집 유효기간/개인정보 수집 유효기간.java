import java.util.*;

class Solution {

	public int[] solution(String today, String[] terms, String[] privacies) {
		String[] split = today.split("\\.");
		int year = Integer.parseInt(split[0]);
		int month = Integer.parseInt(split[1]);
		int day = Integer.parseInt(split[2]);
		// 날짜를 정수로 치환시키기.
		int todayDate = year * 12 * 28 + month * 28 + day;

		// 기간을 담는 해시 만들어서...
		Map<String, Integer> termMap = new HashMap<>();
		for (String term : terms) {
			// 짜르고
			split = term.split(" ");
			// A, B, C ...
			String type = split[0];
			int duration = Integer.parseInt(split[1]);
			// type 넣고, 유효기간 넣고
			termMap.put(type, duration);
		}

		// 파기해야 할 개인정보 번호를 저장할 리스트
		List<Integer> delete = new ArrayList<>();

		// 개인정보 수집 정보 처리
		for (int i = 0; i < privacies.length; i++) {
			// 일단..년도, 타입
			split = privacies[i].split(" ");
			// 날짜
			String collectedDate = split[0];
			// 유효 타입
			String termType = split[1];

			// 수집된 날짜를 기준으로 만료일 계산
			// 유효기간
			int duration = termMap.get(termType);
			split = collectedDate.split("\\.");
			year = Integer.parseInt(split[0]);
			month = Integer.parseInt(split[1]);
			day = Integer.parseInt(split[2]);

			// 유효기간을 더해 새로운 연도와 월 계산
			month += duration;
			year += (month - 1) / 12;
			month = (month - 1) % 12 + 1;

			int finalDate = year * 12 * 28 + month * 28 + day - 1;

			// 만료일이 오늘 이전이라면 파기 대상
			if (finalDate < todayDate) {
				delete.add(i + 1); // 번호는 1부터 시작
			}
		}

		// 결과를 정수 배열로 변환하여 반환
		return delete.stream().mapToInt(Integer::intValue).toArray();
	}

}
