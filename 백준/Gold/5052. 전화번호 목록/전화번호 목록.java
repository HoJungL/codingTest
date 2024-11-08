import java.io.*;
import java.util.*;

public class Main {
    static class Trie{
        boolean end;
        boolean pass;
        Trie[] child;
        
        Trie(){
            end = false;
            pass = false;
            child = new Trie[10];
        }
        public boolean insert(String str, int idx){
            // 현재 노드가 단어의 끝이면.. 다른 단어의 접두사로 포함 X
            if (end) return false;
            
            // 문자열의 끝까지 왔을 경우
            if (idx == str.length()){
                end =true;
                // 해당 지점에서 pass가 true이면, 다른 단어가 이미 이 접두사 뒤로 있음.
                if (pass) return false;
                else return true;
            }else{
                int next = str.charAt(idx) - '0';
                if (child[next] == null) {
                    child[next] = new Trie();
                    pass = true;
                }
                // 재귀적으로 다음 문자 삽입
                return child[next].insert(str, idx + 1);  
            }
        }
    }
    
        public static void main(String[] args) throws Exception{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(in.readLine());
            StringBuilder sb = new StringBuilder();
            
            while(t-- > 0){
                int n = Integer.parseInt(in.readLine());
                String[] numbers = new String[n];
                Trie root = new Trie();
                
                boolean isConsistent = true;
                for (int i = 0 ; i<n; i++){
                    numbers[i] = in.readLine();
                    // 트라이에 삽입하며 일관성 체크
                    if (isConsistent && !root.insert(numbers[i],0)){
                        isConsistent = false;
                    }
                }
                sb.append(isConsistent ? "YES\n":"NO\n");
            }
            System.out.print(sb.toString());
        }
    }