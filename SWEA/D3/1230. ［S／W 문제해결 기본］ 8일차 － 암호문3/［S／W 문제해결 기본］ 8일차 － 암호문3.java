import java.util.*;
import java.io.*;

public class Solution {
	// 링크드 리스트 직접 구현

	static int NODE_MAX = 5000;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// Node
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static class LinkedList {
		Node head;
		Node tail;
		// new를 최소한으로 쓰기 위한 녀석
		// new 이친구 괴애애애애애장이 느림.
		Node[] nodeArr;
		int nodeCnt;

		public LinkedList() {
			head = null;
			nodeArr = new Node[NODE_MAX];
			nodeCnt = 0;
		}

		// 정적 할당 방식
		// 일단 왕창 메모리에 노드를 만들어 놓고,
		// 새로운 노드를 요청시, 여분의 노드중 안쓴거를 가져오는 것
		// -> 시간이 엄청나게 줄어듬
		Node getNewNode(int data) {
			// data를 값으로 갖는 새로운 node 생성하고, 생성된 node를 return
			nodeArr[nodeCnt] = new Node(data);
			return nodeArr[nodeCnt++];
		}

		// 앞에서 idx개 이후에 nums 들을 추가하기
		void insert(int idx, int[] nums) {
			int st = 0;
			if (idx == 0) {// 맨 앞에 붙이는 경우 (head가 변경되어야하는 경우등)
				// 먼저 한개만 추가하고 head 재조정
				if (head != null) {
					Node newNode = getNewNode(nums[0]);
					newNode.next = head;
					head = newNode;
				} else {
					head = getNewNode(nums[0]);
				}
				// 남은 수들은 head 뒤에 차례로 이어 붙어야 함
				idx = 1;
				st = 1;
			}

			Node cur = head;
			// idx 개 만큼 이동하기
			for (int i = 1; i < idx; i++) {
				cur = cur.next;
			}

			// nums 추가하기
			for (int i = st; i < nums.length; i++) {
				Node newNode = getNewNode(nums[i]);
				// 만약 아래의 코드의 순서를 바꾸면...
				// newNode.next 가 본인 스스로가 되버림. 즉, cur.next가 갈곳이 없어집니다..ㅠ
				newNode.next = cur.next;
				cur.next = newNode;
				cur = newNode;
			}
			if (cur.next == null) {
				tail = cur;
			}
		}

		void delete(int idx, int cnt) { // idx 번 인덱스부터 cnt개 만큼 삭제하기
			Node cur = head;
			// 맨 앞이 삭제되는 경우 (head 가 재조정 되는 경우)
			if (idx == 0) {
				for (int i = 0; i < cnt; i++) {
					cur = cur.next;
				}
				head = cur;
				return;
			}
			// idx개 만큼 이동하기
			for (int i = 0; i < idx; i++) {
				cur = cur.next;
			}

			Node anchor = cur; // 삭제되기 직전 위치 기억하기
			for (int i = 0; i < cnt; i++) {
				cur = cur.next;
			}
			anchor.next = cur.next;

			if (anchor.next == null) {
				tail = anchor;
			}
		}

		void add(int data) { // 제일 뒤에 data 추가하기
			Node cur = tail;
			Node newNode = getNewNode(data);
			cur.next = newNode;
			tail = newNode;
		}

		void print() throws Exception { // 출력하기
			int cnt = 10;
			Node cur = head;
			while (--cnt >= 0) {
				bw.write(cur.data + " ");
				cur = cur.next;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		int T = 10;
		StringTokenizer stk;

		for (int t = 1; t <= T; t++) {
			LinkedList list = new LinkedList();
			bw.write("#");
			bw.write(t + " ");
			int n = Integer.parseInt(in.readLine());
			int[] initArr = new int[n];
			stk = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {
				initArr[i] = Integer.parseInt(stk.nextToken());
			}
			list.insert(0, initArr);

			int M = Integer.parseInt(in.readLine());
			stk = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				char cmd = stk.nextToken().charAt(0);
				int x, y;
				switch (cmd) {
				case 'I':
					x = Integer.parseInt(stk.nextToken());
					y = Integer.parseInt(stk.nextToken());
					int[] temp = new int[y];
					for (int j = 0; j < y; j++) {
						temp[j] = Integer.parseInt(stk.nextToken());
					}
					list.insert(x, temp);
					break;
				case 'D':
					x = Integer.parseInt(stk.nextToken());
					y = Integer.parseInt(stk.nextToken());
					list.delete(x, y);
					break;
				case 'A':
					y = Integer.parseInt(stk.nextToken());
					for (int j = 0; j < y; j++) {
						list.add(Integer.parseInt(stk.nextToken()));
					}
					break;
				}
			}
			list.print();
			bw.write("\n");
		}
		bw.flush();
		in.close();
		bw.close();
	}
}