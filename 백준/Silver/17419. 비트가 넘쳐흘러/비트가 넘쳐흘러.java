import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String binaryStr=br.readLine();
		int cnt=0;
		for(char a:binaryStr.toCharArray()) {
			if(a=='1') {
				++cnt;
			}
		}
		System.out.println(cnt);
	}
}