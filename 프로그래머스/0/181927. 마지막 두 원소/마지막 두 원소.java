import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int last = num_list[num_list.length-1];
        int prev = num_list[num_list.length-2];
        int toAdd;
        if (last > prev) {
            toAdd = last - prev;
        } else {
            toAdd = last * 2;
        }
        int[] answer= new int[num_list.length +1];
        for (int i = 0; i<num_list.length; i++){
            answer[i] = num_list[i];
        }
        answer[num_list.length] = toAdd;
        return answer;
    }
}