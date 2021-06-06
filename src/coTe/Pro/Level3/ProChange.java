package coTe.Pro.Level3;

class ProChange {
	public int solution(int n, int[] money) {
		int MOD = 1000000007;

		int[] dp = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {

			if (i % money[0] == 0) {
				dp[i] = 1;
			}

		}

		for (int i = 1; i < money.length; i++) {

			int coin = money[i];
			for (int j = coin; j < n + 1; j++) {

				dp[j] += dp[j - coin] % MOD;

			}

		}

		return dp[n];
	}
}
