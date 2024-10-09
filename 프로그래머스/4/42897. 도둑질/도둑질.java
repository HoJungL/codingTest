class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int answer = 0;

        // 첫번째 집을 털수 있고, 마지막 집은 털지 않는 경우
        int[] dpFirst = new int[n];
        // 첫 집 저장
        dpFirst[0] = money[0];
        // 첫집이랑 두번째 집 비교를 해보아요
        dpFirst[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < n - 1; i++) {
            // 내 DP 값은, 이전 값이랑 전전값이랑 현재위치의 money값을 더한값중 큰거를 넣겠어..
            dpFirst[i] = Math.max(dpFirst[i - 1], dpFirst[i - 2] + money[i]);
        }
        
        // 첫 번째 집을 털지 않고 마지막 집을 털 수 있는 경우
        int[] dpSecond = new int[n];
        // 못털어요 ㅠ
        dpSecond[0] = 0;
        // 대신 두번째 집은 털겠어요.
        dpSecond[1] = money[1];
        for (int i = 2; i < n; i++) {
            // 내 DP 값은, 이전 값이랑 전전값이랑 현재위치의 money값을 더한값중 큰거를 넣겠어..
            // dpSecond[2] = dpSecond[1] 이랑, dpSecond[0] + money[2] 중 큰거를 저장하겠어..
            dpSecond[i] = Math.max(dpSecond[i - 1], dpSecond[i - 2] + money[i]);
        }
        // dpFirst는 마지막 집을 못털어. 마지막집의 위치가 n-1번째니까, n-2 위치가 가장 큰값이겠군
        // dpSecond는 마지막집을 털어. 마지막 집의 위치가 n-1번째니까, n-1 위치가 가장 큰값이겠지?
        answer = Math.max(dpFirst[n-2] , dpSecond[n-1]);
        return answer;
        
    }
}