import java.util.Arrays;

class Solution {
    int[] up = { 0, 1 };
	int[] down = { 0, -1 };
	int[] left = { -1, 0 };
	int[] right = { 1, 0 };
    int[] solution(String[] keyinput, int[] board) {
        int[] answer =  new int[] {0,0};
        // 보드 크기의 최대, 최소 좌표 계산
        int maxX = board[0] / 2;
        int maxY = board[1] / 2;

        for (int i = 0; i < keyinput.length; i++) {
			if (keyinput[i].equals("up")) {
				answer[0] += up[0];
				answer[1] += up[1];
			} else if (keyinput[i].equals("down")) {
				answer[0] += down[0];
				answer[1] += down[1];
			}else if (keyinput[i].equals("left")) {
				answer[0] += left[0];
				answer[1] += left[1];
			}else {
				answer[0] += right[0];
				answer[1] += right[1];
			}
            answer[0] = Math.max(-maxX, Math.min(maxX, answer[0]));
            answer[1] = Math.max(-maxY, Math.min(maxY, answer[1]));
		}
        return answer;
    }
}