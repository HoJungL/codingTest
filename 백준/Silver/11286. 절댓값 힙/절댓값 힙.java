import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	private static int N; // 받는 데이터 개수 입력

	public static void main(String[] args) throws Exception {
		// 데이터 받고
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 데이터 개수 넣고
		N = Integer.parseInt(in.readLine());
		// 비교 연산을 시작해보아요
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int x1 = Math.abs(o1);
		        int x2 = Math.abs(o2);
		        if (x1 > x2) {
		            return 1;
		        }
		        else if(x1 < x2) {
		            return -1;
		        }
		        else{
		            if(o1 == o2){
		                return 0;
		            }
		            else{
		                if(o1>o2)
		                    return 1;
		                else
		                    return -1;
		            }
		        }
			}

		});

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			// 입력값이 0 이 아니라면 값을 넣어 봅시다.

			if (num != 0) {
				queue.offer(num);
			}
			// 만약 비어있는데 출력하라고 하면...입력값이 0이라면 0을 출력해보아용
			else if (queue.isEmpty() && num == 0) {
				System.out.println(0);
			}
			// 안비어있고, 입력값이 0이면.. 맨 위의 값 뽑아용
			else if (num == 0) {
				int a = queue.poll();
				System.out.println(a);
			}
		}
	}
}