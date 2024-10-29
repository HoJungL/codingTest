import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 삼각형 꼭짓점 좌표 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xA = Integer.parseInt(st.nextToken());
        int yA = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int xB = Integer.parseInt(st.nextToken());
        int yB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int xC = Integer.parseInt(st.nextToken());
        int yC = Integer.parseInt(st.nextToken());

        // 삼각형의 넓이 계산
        double area = calc(xA, yA, xB, yB, xC, yC);
        System.out.printf("%.1f\n", area); // 소수점 첫째 자리까지 출력

        // 사과나무 개수 입력
        int N = Integer.parseInt(br.readLine());
        int Count = 0;

        // 사과나무 좌표를 읽고 삼각형 내부에 있는지 확인
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 세 작은 삼각형의 넓이 합이 원래 삼각형 넓이와 같다면 경계 또는 내부에 있음
            double area1 = calc(x, y, xB, yB, xC, yC);
            double area2 = calc(xA, yA, x, y, xC, yC);
            double area3 = calc(xA, yA, xB, yB, x, y);

            if (Math.abs(area - (area1 + area2 + area3)) < 1e-9) {
                Count++;
            }
        }

        // 결과 출력
        System.out.println(Count);
    }

    // 삼각형의 넓이를 계산하는 함수
    private static double calc(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
    }
}