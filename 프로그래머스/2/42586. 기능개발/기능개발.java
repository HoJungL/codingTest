import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int n = progresses.length;

        // 각 기능의 남은 일수를 계산합니다.
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int i = 0;
        while (i < n) {
            int count = 1; // 첫 번째 기능은 항상 배포되므로 count를 1로 초기화
            int releaseDay = days[i]; // 첫 번째 기능의 배포일

            // 다음 기능들이 같은 날 배포될 수 있는지 확인
            while (i + 1 < n && days[i + 1] <= releaseDay) {
                count++;
                i++;
            }
            answer.add(count); // 배포되는 기능 수를 저장
            i++; // 다음 기능으로 이동
        }

        // ArrayList를 int 배열로 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
