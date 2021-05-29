package coTe.Pro.Level3;

import java.util.Arrays;

class ProBuildPillarAndBeam {

	static boolean[][][] buildArr;
	static int answerSize = 0;
	
	public static void main(String[] args) {
		
		int n = 5;
		int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		
		int[][] ans = solution(n, build_frame);
		
		for(int i = 0 ; i < ans.length; i++) {
			System.out.println(Arrays.toString(ans[i]));
		}
		
		
	}
	public static int[][] solution(int n, int[][] build_frame) {
		int[][] answer = {};

		buildArr = new boolean[n+1][n+1][2];

		for (int[] build : build_frame) {

			int x = build[0];
			int y = build[1];

			if (build[2] == 0) {

				if (x > n + 1 || y >= n ) { // 맵을 넘어가는 조건은 continue;
					continue;
				}

				if (build[3] == 1) {

					if (insertPillar(n, build, x, y)) {
						buildArr[x][y][0] = true;
						answerSize++;
					}

				} else {

					if (!delete(n, build, x, y, 0)) {
						buildArr[x][y][0] = true;
						answerSize++;
					}

				}

			} else {

				if (x >= n || y >= n + 1) { // 맵을 넘어가는 조건은 continue;
					continue;
				}

				if (build[3] == 1) {

					if (insertBeam(n, build, x, y)) {
						buildArr[x][y][1] = true;
						answerSize++;
					}

				} else {

					if (!delete(n, build, x, y, 1)) {
						buildArr[x][y][1] = true;
						answerSize++;
					}
				}

			}

		}
		answer = new int[answerSize][3];
		int idx = 0;
		for (int i = 0; i <= n; i++) {

			for (int j = 0; j <= n; j++) {

				for (int k = 0; k < 2; k++) {

					if (buildArr[i][j][k]) {
						answer[idx][0] = i;
						answer[idx][1] = j;
						answer[idx][2] = k;
						idx++;
					}

				}

			}

		}

		return answer;
	}

	public static boolean insertPillar(int n, int[] build, int x, int y) {

		if (y == 0) { // x가 0보다 크다 해줘야 할수도.
			buildArr[x][y][0] = true;
			return true;
		}

		if (x > 0) {

			if (buildArr[x - 1][y][1]) {
				return true;
			}

		}

		if (buildArr[x][y - 1][0] || buildArr[x][y][1] ) {
			return true;
		
		}

		return false;
	}

	public static boolean insertBeam(int n, int[] build, int x, int y) {

		if (y == 0) {
			return false;
		}

		if (buildArr[x][y - 1][0] || buildArr[x + 1][y - 1][0]) {
			return true;
		}

		if (x - 1 >= 0) {

			if (buildArr[x - 1][y][1] && buildArr[x + 1][y][1]) {
				return true;
			}

		}

		return false;

	}

	public static boolean delete(int n, int[] build, int x, int y, int type) { // 지웠다고 생각하고 건축물 이상없는지 확인.

		buildArr[x][y][type] = false;
		answerSize--;
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				if (buildArr[i][j][0] && !insertPillar(n, build, i, j)) {
					return false;
				}

				if (buildArr[i][j][1] && !insertBeam(n, build, i, j)) {
					return false;
				}

			}

		}

		return true;
	}

}