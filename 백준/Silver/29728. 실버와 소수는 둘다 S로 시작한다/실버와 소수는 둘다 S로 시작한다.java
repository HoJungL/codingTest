import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int bCount = 0; // B의 개수
        int sCount = 0; // S의 개수
        boolean[] isPrime = sieveOfEratosthenes(N); // 소수 판별 배열

        boolean lastWasB = false; // 마지막 문자가 B인지 여부를 저장

        for (int i = 1; i <= N; i++) {
            if (!isPrime[i]) {
                // 소수가 아닌 경우
                bCount++;
                lastWasB = true;
            } else {
                // 소수인 경우
                if (lastWasB) {
                    // 마지막 문자가 B인 경우
                    bCount--;
                    sCount += 2; // 기존 B를 S로 변경 + 새로운 S 추가
                } else {
                    sCount++; // 새로운 S 추가
                }
                lastWasB = false;
            }
        }

        // 결과 출력
        System.out.println(bCount + " " + sCount);
    }

    // 에라토스테네스의 체로 소수를 판별하는 함수
    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}