import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 데이터 받을 배열
		int[] list = new int[10];
		int[] sum = new int[10];
		// 10번
		for (int i = 0; i < 10; i++) {
			list[i] = Integer.parseInt(in.readLine());
		}
		sum[0] = list[0];

		// 10번 동안 데이터를 합쳐주세용
		for (int i = 1; i < 10; i++) {
			sum[i] = sum[i - 1] + list[i];

			// 100이면
			if (sum[i] == 100) {
				System.out.println(sum[i]);
				break;
			}
			// 100이상일때..
			else if (sum[i] > 100) {
				// 현재 값과 이전값이 100 과의 거리가 같으면
				if (100 - sum[i - 1] == sum[i] - 100) {
					System.out.println(sum[i]);
					break;
				}
				// 100과의 거리가 [i-1]이 더 작으면
				else if (100 - sum[i - 1] < sum[i] - 100) {
					System.out.println(sum[i - 1]);
					break;
				}
				// 100과의 거리가 [i]이 더 작으면

				else if (100 - sum[i - 1] >= sum[i] - 100) {
					System.out.println(sum[i]);
					break;
				}
			}
			// 다 돌았는데, 아직 100 이하라면
			if (sum[9] < 100 && i == 9) {
				System.out.println(sum[9]);
				break;
			}

		}

	}
}