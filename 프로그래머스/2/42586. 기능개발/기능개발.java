import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> daysQueue = new ArrayDeque<>();  // LinkedList 대신 ArrayDeque 사용

        // 각 작업의 완료까지 남은 일수를 계산하여 큐에 저장
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            daysQueue.offer(days);
        }

        // 첫 번째 작업의 완료 일수를 꺼냄
        int currentMax = daysQueue.poll();
        int count = 1;

        // 큐에서 남은 작업들을 순차적으로 확인
        while (!daysQueue.isEmpty()) {
            int current = daysQueue.poll();

            if (current <= currentMax) {
                // 현재 작업이 현재 최대 일수보다 적거나 같으면 함께 배포 가능
                count++;
            } else {
                // 현재 작업이 더 많은 일수를 필요로 한다면
                // 이전 작업들까지의 배포를 완료하고 새로운 배포를 시작
                result.add(count);
                currentMax = current;  // 새로운 최대 일수로 설정
                count = 1;  // 카운트를 초기화
            }
        }

        // 마지막 배포 작업을 리스트에 추가
        result.add(count);

        // 결과 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
