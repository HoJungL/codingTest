import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> hash = new HashSet<>();
		List<Integer> answer1 = new ArrayList<>();
		int count = 0;
		int num = 0;
		int time = 0;
		int len = 0;
		// 원래 있던거 말할경우
		for (int i = 0; i < words.length; i++) {
		    if (!hash.contains(words[i])) {
		        if (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
		            num = (i % n) + 1;
		            time = (i / n) + 1;
		            answer1.add(num);
		            answer1.add(time);
		            break;
		        }
		        hash.add(words[i]);
		    } else {
		        num = (i % n) + 1;
		        time = (i / n) + 1;
		        answer1.add(num);
		        answer1.add(time);
		        break;
		    }
		}
        if (answer1.size() ==0){
			answer1.add(0);
			answer1.add(0);
		}
        
		int[] answer = new int[answer1.size()];
		for (int i = 0 ; i<answer1.size(); i++) {
			answer[i] = answer1.get(i);
		}

        return answer;
    }
}