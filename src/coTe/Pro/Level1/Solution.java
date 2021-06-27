package coTe.Pro.Level1;

class Solution {
	public int solution(int n) {
		int[] dp = new int[n + 1];

		for (int i = 2; i <= n; i++) {

			if (calc(i)) {
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = dp[i - 1];
			}

		}

		return dp[n];
	}

	public boolean calc(int num) {

		for (int i = 2; i < num; i++) {

			if (num % i == 0) {
				return false;
			}

		}

		return true;
	}
}