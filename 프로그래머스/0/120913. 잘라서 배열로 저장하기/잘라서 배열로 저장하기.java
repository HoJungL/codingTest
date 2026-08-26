class Solution {
    public String[] solution(String my_str, int n) {
        int length  = my_str.length();
        int count = (length + n - 1) / n;
        String[] answer = new String[count];
        
        for (int i = 0 ; i <count ; i++){
            int start = i *n;
            int end = Math.min(start + n , length);
            
            answer[i] = my_str.substring(start,end);
        }
        
        return answer;
    }
}