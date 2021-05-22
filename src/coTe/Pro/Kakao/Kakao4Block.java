package coTe.Pro.Kakao;

class Kakao4Block {

	static int[] xx = { 0, 0, 1, 1 };
	static int[] yy = { 0, 1, 0, 1 };
	static boolean[][] fourBlockXY;
	static char[][] blockArr;
	static int m, n;
	static boolean hasBlock = false;
	static int cnt = 0; // 4개짜리 블럭이 없을경우 끝내기위해서 존재

	public static void main(String[] args) {

		m = 4;
		n = 5;

		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

		int answer = solution(m, n, board);

		System.out.println(answer);

	}

	public static int solution(int m, int n, String[] board) {

//		this.m = m;
//		this.n = n;

		int answer = 0;

		blockArr = new char[m][n];

		for (int i = 0; i < m; i++) {

			String tempStr = board[i];
			for (int j = 0; j < n; j++) {

				blockArr[i][j] = tempStr.charAt(j);

			}
		}

		findFourBlock(0, 0);

		answer = cnt;

		return answer;
	}

	public static void findFourBlock(int x, int y) {

		fourBlockXY = new boolean[m][n];

		for (int i = x; i < m; i++) {

			for (int j = y; j < n; j++) {

				if (blockArr[i][j] != ' ') {

					char name = blockArr[i][j];
					recursion(i, j, name);

				}

			}
		}

		if (hasBlock) {

			countBlock();
			findFourBlock(0, 0);
		}
	}

	public static void recursion(int x, int y, char name) {

		// 4개 중 한점을 기준으로 저장해둬야할듯

		for (int i = 0; i < xx.length; i++) {

			int dx = x + xx[i];
			int dy = y + yy[i];

			if (dx >= 0 && dy >= 0 && dx < m && dy < n ) {

				if (blockArr[dx][dy] != name) { // 네모중 한개라도 다르면 return;
					return;
				}

			} else {
				return;
			}

		}

		fourBlockXY[x][y] = true; // 네모확보했으니 1점을 기준으로 true해줌
		hasBlock = true;

	}

	public static void countBlock() {

		boolean[][] CntBlock = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (fourBlockXY[i][j]) {
					for (int k = 0; k < xx.length; k++) {
						int dx = i + xx[k];
						int dy = j + yy[k];

						CntBlock[dx][dy] = true;
						blockArr[dx][dy] = ' ';
					}
				}
			}
		}

		for (int i = 0; i < m; i++) { // 갯수세기
			for (int j = 0; j < n; j++) {
				if (CntBlock[i][j]) {
					cnt++;
				}
			}
		}

		// 여기부터 빈값 내리기

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m - 1; j++) {

				if (blockArr[j][i] != ' ' && blockArr[j + 1][i] == ' ') {
					char temp = blockArr[j][i];
					blockArr[j][i] = blockArr[j + 1][i];
					blockArr[j + 1][i] = temp;
					j = -1;
				}
			}
		}

		hasBlock = false;

	}
}