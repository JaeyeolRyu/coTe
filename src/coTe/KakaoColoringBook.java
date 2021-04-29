package coTe;

class KakaoColoringBook {

	int[] xx = { 0, 0, -1, 1 };
	int[] yy = { -1, 1, 0, 0 };
	boolean[][] visit;
	int[][] picture;
	int max = 0;
	int colorCnt,m,n;
	
	public int[] solution(int m, int n, int[][] picture) {

		this.m = m;
		this.n = n;
		this.picture = picture;
		
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;

		visit = new boolean[m][n];
	
		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (picture[i][j] != 0 && !visit[i][j]) {
					colorCnt = 1;
					answer[0]++;
					visit[i][j] = true;
					findSize(i, j, picture[i][j]);
				}
			}
		}

		answer[1] = max;

		return answer;
	}

	public void findSize(int x, int y, int color) {

		for (int i = 0; i < 4; i++) {

			int dx = x + xx[i];
			int dy = y + yy[i];
			
			if(dx >= 0 && dy >= 0 && dx < m && dy < n) {			
				if (!visit[dx][dy] && picture[dx][dy] == color) {
	
					colorCnt++;
					visit[dx][dy] = true;
	
					findSize(dx, dy, color);
	
				}
			}
		}
		max = Math.max(max, colorCnt);
	}
}