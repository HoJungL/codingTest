import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		// 결과를 저장할 리스트 두둥
		List<Integer> result = new ArrayList<>();

		Queue<Integer> queue = new ArrayDeque<>();

		// 각 작업의 완료까지 남은 일수를 계산하여 큐에 저장
		for (int i = 0; i < progresses.length; i++) {
			// Math.ceil : 올림 했어요. (100 - 현재개발현황) / 일별 속도
			int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
			// 남은 일수 큐 추가
			queue.offer(days);
		}

		// 첫 번째 작업의 완료 일수를 꺼냄
		int currentMax = queue.poll(); // 현재 최대 일수를 첫 번째 작업으로 설정
		int count = 1; // 배포 가능한 작업의 수 초기화

		// 큐에서 남은 작업들 확인
		while (!queue.isEmpty()) {
			// 다음 작업의 남은 일수
			int current = queue.poll();

			// 현재 작업이 현재 최대 일수보다 적거나 같으면
			if (current <= currentMax) {
				// 같이 배포하쟈
				count++;
			} else {
				// 현재 작업이 더 많은 일수를 필요로 한다면
				// 이전 작업들까지의 배포를 완료하고 새로운 배포를 시작
				result.add(count); // 현재까지의 배포 가능한 작업 수를 결과 리스트에 추가
				// 새로운 최대 일수로 초기화
				currentMax = current;
				// 새로운 배포 그룹 시작하고, 초기화
				count = 1;
			}
		}

		// 마지막 배포 작업을 리스트에 추가
		result.add(count);

		// 결과 리스트를 배열로 변환하여 반환
		// 난 아직 이게 너무 불편해...
		int[] answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}
}
