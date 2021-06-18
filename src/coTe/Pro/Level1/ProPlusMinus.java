package coTe.Pro.Level1;

class ProPlusMinus {
	int ans = 0;

	public int solution(int left, int right) {

		for (int i = left; i <= right; i++) {
			checkCnt(i);
		}

		return ans;
	}

	public void checkCnt(int n) {

		int cnt = 0;

		for (int i = 1; i <= n; i++) {

			if (n % i == 0) {
				cnt++;
			}
		}

		if (cnt % 2 == 0) {
			ans += n;
		} else {
			ans -= n;
		}
		
	}
}