import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String N = in.readLine();
        int[] count = new int[10];

        // 숫자의 개수를 센다
        for (char c : N.toCharArray()) {
            count[c - '0']++;
        }

        // 6과 9를 합쳐서 계산
        int sixNineCount = (count[6] + count[9] + 1) / 2; // +1을 통해 올림 효과
        int max = sixNineCount; // 6과 9의 합쳐서 계산한 수가 기본값

        // 6과 9를 제외한 다른 숫자들을 고려
        for (int i = 0; i < 10; i++) {
            if (i != 6 && i != 9) {
                if (count[i] > max) {
                    max = count[i];
                }
            }
        }

        System.out.println(max);
    }
}