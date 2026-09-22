import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i <input.length();i++){
            char cha = input.charAt(i);
            
            if (Character.isUpperCase(cha)){
                sb.append(Character.toLowerCase(cha));
            } else{
                sb.append(Character.toUpperCase(cha));
            }
        }
        System.out.println(sb);
    }
}
