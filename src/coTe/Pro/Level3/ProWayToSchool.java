package coTe.Pro.Level3;

class ProWayToSchool {
	int[][] dp;

	public int solution(int m, int n, int[][] puddles) {

		dp = new int[m+1][n+1];

		for (int[] puddle : puddles) {

			dp[puddle[0]][puddle[1]] = -1;

		}

		for (int i = 1; i <= m; i++) {
			
			if(dp[i][1] == -1) {
				break;
			}
			dp[i][1] = 1;
		}

		for (int i = 1; i <= n; i++) {
			if(dp[1][i] == -1) {
				break;
			}
			dp[1][i] = 1;
		}

		
		
		searchRoute(m, n);

		return dp[m][n];
	}

	public void searchRoute(int m, int n) {

		for (int i = 2; i <= m; i++) {

			for (int j = 2; j <= n; j++) {

				if (dp[i][j] == -1) {
					continue;
					
				} else if (dp[i - 1][j] == -1 && dp[i][j - 1] == -1) {

					dp[i][j] = 0;
				} else if (dp[i - 1][j] == -1) {

					dp[i][j] = dp[i][j - 1];
				} else if (dp[i][j - 1] == -1) {

					dp[i][j] = dp[i - 1][j];
				} else {

					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1])%1000000007;
				}

			}

		}

	}

}