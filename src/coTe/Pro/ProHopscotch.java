package coTe.Pro;

class ProHopscotch {

	public static void main(String[] args) {

		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };

		int ans = solution(land);

		System.out.println(ans);

	}

	static int solution(int[][] land) {
		int answer = 0;

		int[][] dp = new int[land.length][land[0].length];

		for (int i = 0; i < land[0].length; i++) {

			dp[0][i] = land[0][i];

		}

		for (int i = 1; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				for (int k = 0; k < land[0].length; k++) {

					if (k == j) {
						continue;
					}

					dp[i][j] = Math.max(dp[i - 1][k] + land[i][j], dp[i][j]);
					System.out.println(dp[i][j]);
				}

			}

		}

		for (int i = 0; i < land[0].length; i++) {

			answer = Math.max(answer, dp[land.length - 1][i]);
		}

		return answer;
	}
}