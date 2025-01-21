import java.util.*;
import java.io.*;

public class Solution {

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int test_case = 10;

		for (int t = 1; t <= test_case; t++) {
			// 원본 암호문 뭉치속 암호문 개수 n (3198)
			int n = Integer.parseInt(in.readLine());

			// 암호문 담을 연결 리스트(801, 482, ....)
			list = new ArrayList<>();
			st = new StringTokenizer(in.readLine());

			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			// 명령어 개수 (425)
			int m = Integer.parseInt(in.readLine());
			
			st = new StringTokenizer(in.readLine());

			for (int i = 0; i < m; i++) {
				char cmd = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				fun(cmd, x);
			}
			
			sb.append("#" + t);
			// 암호문중 10개만 출력
			for (int i = 0; i < 10; i++) {
				sb.append(" " + list.get(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void fun(char cmd, int x) {
		int y;
		switch (cmd) {
		case 'I':
			y = Integer.parseInt(st.nextToken());
			for (int i = 0, insertIdx = x; i < y; i++, insertIdx++) {
				list.add(insertIdx, Integer.parseInt(st.nextToken()));
			}
			break;
		case 'D':
			y = Integer.parseInt(st.nextToken());
			for (int i = 0; i < y; i++) {
				list.remove(x);
			}
			break;
		case 'A':
			for (int i = 0; i < x; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			break;
		}
	}
}