class Solution {
    public String[] solution(String[] names) {
        int len = (names.length + 4) / 5;
        
        String[] answer = new String[len];
        int idx = 0 ;
        for (int i = 0 ; i <names.length;i++){
            if (i % 5 ==0){
                answer[idx++] = names[i];
            }
        }
        return answer;
    }
}