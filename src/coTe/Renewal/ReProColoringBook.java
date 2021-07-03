package coTe.Renewal;

class ReProColoringBook {

	int[][] xy = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	int m, n;
	int[][] picture;
	boolean[][] visit;

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		this.m = m;
		this.n = n;
		this.picture = picture;

		visit = new boolean[m + 1][n + 1];

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (!visit[i][j] && picture[i][j] != 0) {
					visit[i][j] = true;
					numberOfArea++;
					int cnt = search(i, j, 1, picture[i][j]);
					maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);

				}

			}

		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public int search(int x, int y, int cnt, int color) {
		for (int k = 0; k < 4; k++) {

			int dx = x + xy[k][0];
			int dy = y + xy[k][1];

			if (dx >= 0 && dy >= 0 && dx < m && dy < n) {

				if (!visit[dx][dy] && picture[dx][dy] == color) {
					visit[dx][dy] = true;
					cnt += search(dx, dy, 1, color);
					System.out.println(dx + "  " + dy + "   " + cnt);
				}

			}

		}

		return cnt;

	}

}