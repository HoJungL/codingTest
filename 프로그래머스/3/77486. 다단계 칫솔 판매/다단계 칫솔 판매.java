import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 판매원 수만큼 늘어나고
        int[] answer = new int[enroll.length];

        // key : value = 자식 : 부모 상납하고.. 
        HashMap<String, String> hashMap = new HashMap<>(); 
        // key : value  = 나, 내 위에 몇명있니..
        HashMap<String, Integer> indexMap  = new HashMap<>(); 

        for(int i=0; i < enroll.length; i++){
            // 판매원 넣고, 해당 판매원을 참여시킨 XX 놈(?)
            hashMap.put(enroll[i], referral[i]);
            // 판매원 넣고, 나는 몇번째인지 넣고..
            indexMap .put(enroll[i], i);
        }

        // 판매량 집계 (어느 판매원 꺼를 가져온거지?)
        for(int i=0; i<seller.length; i++){
            // 어떤 판매원꺼임? ->
            String now = seller[i];
            int profit = 100 * amount[i];
            
            while(!now.equals("-")){
                // 부모에게 넘겨줄 금액
                int profitForParent = profit / 10; 
                // 내가 얻은 것 - 뺏긴거..
                int nowProfit = profit - profitForParent; 

                // 자신의 index에 금액만큼 더함
                answer[indexMap.get(now)] += nowProfit;

                // 노드는 부모로 이동하면서 수익을 부모에게 넘겨준 금액으로 초기화
                now = hashMap.get(now);
                profit = profit / 10;

                // 10%의 금액이 1원 미만인 경우
                if (profit < 1) {
                    break;
                }
            }
        }
        return answer;
    }
}
