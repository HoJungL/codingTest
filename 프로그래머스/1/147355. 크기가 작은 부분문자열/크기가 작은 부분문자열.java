class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0 ; i <t.length()-p.length()+1;i++){
            // System.out.println(" p.length()+i : " + p.length()+"+"+i);

            String str = t.substring(i, p.length()+i);
            Double numStr = Double.parseDouble(str);
            Double numP = Double.parseDouble(p);
            // System.out.println(" numStr : " + numStr);
            // System.out.println(" numP : " + numP);
            if (numStr <= numP){
                answer++;
            }
        }
        return answer;
    }
}