import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/17070
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] matrix = new int[n][n];
        int[][][] D = new int[n][n][3];  // 0=가로, 1=세로, 2=대각

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < n; j++) {
            	matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        D[0][1][0] = 1;  // 최초 상태
        for(int i = 0; i < n; i++) {
            for(int j = 2; j < n; j++) {
                if(j - 1 >= 0 && matrix[i][j] == 0) {  // 가로
                    D[i][j][0] = D[i][j-1][0] + D[i][j-1][2];
                }
                if(i - 1 >= 0 && matrix[i][j] == 0) {  // 세로
                    D[i][j][1] = D[i-1][j][1] + D[i-1][j][2];
                }
                if(i-1 >= 0 && j-1 >= 0 && matrix[i][j] == 0 && matrix[i-1][j] == 0 && matrix[i][j-1] == 0) {  // 대각
                    D[i][j][2] = D[i-1][j-1][0] + D[i-1][j-1][1] + D[i-1][j-1][2];
                }
            }
        }
        System.out.println(D[n-1][n-1][0] + D[n-1][n-1][1] + D[n-1][n-1][2]);
	}

}