package coTe.Pro.Level3;

class ProLongJump {
	long[] dp;

	public long solution(int n) {
		long answer = 0;

		dp = new long[n + 1];
		dp[0] = dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
		}
		answer = dp[n];

		return answer;
	}

}
