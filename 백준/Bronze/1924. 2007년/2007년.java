import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = in.readLine().split(" ");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		int day = y;
		String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		for (int i = 1; i<x; i++) {
			if (i == 1 ||i ==  3 || i == 5||i == 7||i == 8||i == 10||i == 12) {
				day+= 31;
			}else if (i ==2) {
				day+= 28;
			}else {
				day +=30;
			}
		}
		day = (int)day%7;
		System.out.println(days[day]);
	}
}