class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank= {6,6,5,4,3,2,1};
        int zero = 0;
        int count = 0;
        for(int i : lottos){
            if(i == 0) {
                zero++;
            }
        }
        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j < lottos.length; j++){
                if(lottos[i] == win_nums[j]) {
                    count++;
                }
            }
        }
        
        answer[0] = rank[count+zero];
        answer[1] = rank[count];
        
        return answer;
    }
}