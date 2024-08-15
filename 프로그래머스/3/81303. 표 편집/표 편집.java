import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) { 
        
        Stack<Integer> stack = new Stack<>();  // 삭제된 행의 인덱스를 저장하는 스택
        int table_size = n;  // 현재 테이블의 행 수
        
        for(int i = 0; i < cmd.length; i++) {  // 명령어 배열을 순회
            char c = cmd[i].charAt(0);  // 명령어의 첫 글자를 가져옴

            if(c == 'U') {  // 'U' 명령어: 현재 위치에서 위로 이동
                // k : 행수
                k -= Integer.valueOf(cmd[i].substring(2));  // 명령어에서 이동할 행 수를 추출하여 k에서 빼줌
            } else if(c == 'D') {  // 'D' 명령어: 현재 위치에서 아래로 이동
                k += Integer.valueOf(cmd[i].substring(2));  // 명령어에서 이동할 행 수를 추출하여 k에 더해줌
            } else if(c == 'C') {  // 'C' 명령어: 현재 행 삭제
                stack.push(k);  // 현재 행의 인덱스를 스택에 저장
                table_size -= 1;  // 테이블의 행 수를 줄임
                if(k == table_size) k -= 1;  // 만약 삭제된 행이 마지막 행이라면, k를 한 칸 위로 이동
            } else {  // 'Z' 명령어: 최근 삭제된 행 복구
                int r = stack.pop();  // 스택에서 삭제된 행의 인덱스를 꺼냄
                if(k >= r) k += 1;  // 만약 현재 위치가 삭제된 행의 위치보다 크거나 같다면, k를 한 칸 아래로 이동
                table_size += 1;  // 테이블의 행 수를 증가시킴
            }
        }
        
        // 최종 테이블 상태를 문자열로 반환
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < table_size; i++) {  // 현재 테이블의 모든 행을 'O'로 채움
            sb.append('O');
        }
        while(!stack.isEmpty()) {  // 삭제된 행의 인덱스들을 이용하여 'X'를 삽입
            sb.insert(stack.pop().intValue(), 'X');
        }
        return sb.toString();  // 최종 결과 문자열 반환
    }
}
