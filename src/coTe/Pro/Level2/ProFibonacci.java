package coTe.Pro.Level2;

class ProFibonacci {

	int[] dp;

	public int solution(int n) {
		int answer = 0;

		dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		answer = fibonacci(n);
		return answer;
	}

	public int fibonacci(int n) {

		for (int i = 2; i <= n; i++) {

			dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;

		}

		return dp[n];
	}
}