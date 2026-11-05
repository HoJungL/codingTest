class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < my_string.length();i++){
            char cha = my_string.charAt(i);
            if (Character.isUpperCase(cha)){
                sb.append(Character.toLowerCase(cha));
            }else{
                sb.append(Character.toUpperCase(cha));
            }
        }
        return sb.toString();
    }
}