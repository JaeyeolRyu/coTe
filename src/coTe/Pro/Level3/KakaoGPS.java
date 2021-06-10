package coTe.Pro.Level3;

import java.util.Arrays;

class KakaoGPS {
	public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		int answer = 0;
		int INF = 987654321;

		int[][] dp = new int[k][n + 1];
		int[][] roadArr = new int[n + 1][n + 1];

		for (int[] edge : edge_list) {
			int node1 = edge[0];
			int node2 = edge[1];
			roadArr[node1][node2] = roadArr[node2][node1] = 1;
		}

		for (int i = 0; i < k; i++) {
			Arrays.fill(dp[i], INF);
		}

		dp[0][gps_log[0]] = 0;

		for (int i = 0; i < k - 1; i++) {

			for (int j = 1; j < n + 1; j++) {

				if (dp[i][j] == INF) {
					continue;
				}

				for (int l = 1; l < n + 1; l++) {

					if (roadArr[j][l] == 1) {
						
						int cnt = dp[i][j];
						
						if (l != gps_log[i + 1]) {
							cnt++;
						}
						
						dp[i + 1][l] = Math.min(cnt, dp[i + 1][l]);
						
					}

				}

			}

		}

		answer = dp[k - 1][gps_log[k - 1]];

		if (answer == INF) {
			return -1;
		} else {
			return answer;
		}

	}
}