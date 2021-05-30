package coTe.Pro.Kakao;

class KakaoWalkersHeaven {
	static int MOD = 20170805;

	public static void main(String[] args) {

		int m = 3;
		int n = 7;
		int[][] cityMap = { { 0, 2, 0, 0, 0, 2, 0 }, { 0, 0, 2, 0, 1, 0, 1 }, { 1, 0, 2, 2, 2, 2, 0 } };
		int ans = solution(m, n, cityMap);
		System.out.println(ans);

	}

	public static int solution(int m, int n, int[][] cityMap) {

		int[][][] roadMap = new int[m + 1][n + 1][2];

		roadMap[1][1][0] = roadMap[1][1][1] = 1;

		for (int i = 1; i <= m; i++) {

			for (int j = 1; j <= n; j++) {

				if (cityMap[i - 1][j - 1] != 1) {

					if (cityMap[i - 1][j - 1] == 2) {

						roadMap[i][j][0] += roadMap[i][j - 1][0];
						roadMap[i][j][1] += roadMap[i - 1][j][1];
						continue;
					}

					roadMap[i][j][0] += (roadMap[i][j - 1][0] + roadMap[i - 1][j][1]) % MOD;
					roadMap[i][j][1] += (roadMap[i][j - 1][0] + roadMap[i - 1][j][1]) % MOD;
					continue;
				}

				roadMap[i][j][0] = 0;
				roadMap[i][j][1] = 0;

			}

		}

		return roadMap[m][n][0];
	}
}