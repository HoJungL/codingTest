class Solution {
	public int solution(int n) {
		int ans = 0;
		// 0 될때까지 돌면되잖아..
		while (n > 0) {
			// N이 홀수일 때는 1칸 점프
			if (n % 2 == 1) {
				// 한칸 뛰었으니 n을 하나 줄여보겠어.
				n--;
				// 한칸 뛰었으니... 에너지 좀 썻다 ㅠ
				ans++;
			}
			// N이 짝수일 때는 순간이동(배터리안씀 너무 조아)
			n /= 2;
		}
		return ans;
	}
}
