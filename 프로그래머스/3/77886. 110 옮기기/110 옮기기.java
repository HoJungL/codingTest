import java.util.Stack;

class Solution {
	public String[] solution(String[] s) {
		String[] answer = new String[s.length];

		for (int i = 0; i < s.length; i++) {
            Stack<Character> stack = new Stack<>();
			int count = 0;

			// "110"을 모두 제거하면서 카운트
			for (int j = 0; j < s[i].length(); j++) {
				char a = s[i].charAt(j);
                
                if (stack.size() >1){
                    char b = stack.pop();
                    char c = stack.pop();
                    
                    if (a =='0' && b =='1'&&c=='1'){
                        count++;
                    }else{
                        stack.push(c);
                        stack.push(b);
                        stack.push(a);
                    }
                }else{
                    stack.push(a);
                }
			}

			// 111이 끝나는 곳을 탐색. 이곳에 붙이면 되니까.
            StringBuilder sb = new StringBuilder();
			int insert = stack.size();
            boolean flag = false;
			
			while(!stack.isEmpty()){
                if(!flag){
                    if (stack.peek() =='1'){
                        insert--;
                    }else{
                        flag = true;
                    }
                }
                sb.insert(0,stack.pop());
            }
                while(count-- >0){
                    sb.insert(insert, "110");
                    insert += 3;
                }
                answer[i] = sb.toString();
            }
            
		return answer;
    }
}

