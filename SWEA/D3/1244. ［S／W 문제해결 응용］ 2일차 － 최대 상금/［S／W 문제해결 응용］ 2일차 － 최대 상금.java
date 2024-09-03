import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    static String N;
    static int intN;
    static int max = 0;
    static int[] arr;
    static Set<String> visited;

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader((new InputStreamReader(System.in)));
        int T;
        T = Integer.parseInt(in.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] split = in.readLine().split(" ");
            N = split[0];
            intN = Integer.parseInt(split[1]);  // 남은 교환 횟수
            arr = new int[N.length()];
            visited = new HashSet<>();

            for (int i = 0; i < arr.length; i++) {
                arr[i] = N.charAt(i) - '0';
            }

            DFS(0);
            System.out.println("#" + test_case + " " + max);
            max = 0;
        }
    }

    static void DFS(int depth) {
        // 현재 배열 상태를 문자열로 변환하여 저장
        String current = toString(arr);
        if (visited.contains(current + depth)) {
            return;
        }
        visited.add(current + depth);

        if (depth == intN) {
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                result = result * 10 + arr[i];
            }
            max = Math.max(result, max);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(i, j);
                DFS(depth + 1);
                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(n);
        }
        return sb.toString();
    }
}