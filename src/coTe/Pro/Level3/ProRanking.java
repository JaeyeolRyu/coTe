package coTe.Pro.Level3;

import java.util.Arrays;

class ProRanking {

	static int INF = 10001;
	
	public static void main(String[] args) {
		
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		
		int ans = solution(n, results);
		
		System.out.println(ans);
	}
	
	public static int solution(int n, int[][] results) {
		int answer = 0;

		int[][] resultArr = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {

			Arrays.fill(resultArr[i], INF);
			resultArr[i][i] = 0;

		}

		for (int[] result : results) {

			int win = result[0];
			int lose = result[1];

			resultArr[win][lose] = 1;

		}

		answer = checkRank(n, resultArr);

		return answer;
	}

	public static int checkRank(int n, int[][] resultArr) {

		int cnt = 0;

		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {

					if (resultArr[i][j] > resultArr[i][k] + resultArr[k][j]) {
						resultArr[i][j] = resultArr[i][k] + resultArr[k][j];
					}

				}

			}

		}
		
		for (int i = 1; i < n + 1; i++) {
			int knowCnt = 0;

			for (int j = 1; j < n + 1; j++) {

				if (resultArr[i][j] != INF || resultArr[j][i] != INF) {

					knowCnt++;

				}

			}
			
			if (knowCnt == n) {
				cnt++;
			}

		}
		
		return cnt;

	}

}