package coTe.Pro;

class ProRouteCnt {

	public static void main(String[] args) {

		String dirs = "UD";
		int ans = solution(dirs);

		System.out.println(ans);

	}

	public static int solution(String dirs) {
		int answer = 0;

		String[][] idxArr = new String[11][11];
		
		for(int i = 0 ; i < 11; i++) {
			for(int j = 0 ; j < 11; j++) {
				idxArr[i][j] = "";
			}
		}

		int x = 5;
		int y = 5;

		for (int i = 0; i < dirs.length(); i++) {

			switch (dirs.charAt(i)) {
			case 'U':

				if (x + 1 <= 10) {

					x += 1;

					if (idxArr[x][y].contains(" U")) {
						break;
					} else {
						idxArr[x][y] += " U";
						idxArr[x-1][y] += " D";
						answer++;
					}

				}

				break;
			case 'D':

				if (x - 1 >= 0) {

					x -= 1;

					if (idxArr[x][y].contains(" D")) {
						break;
					} else {
						idxArr[x][y] += " D";
						idxArr[x+1][y] += " U";
						answer++;
					}
				}

				break;
			case 'L':

				if (y - 1 >= 0) {

					y -= 1;

					if (idxArr[x][y].contains(" L")) {
						break;
					} else {
						idxArr[x][y] += " L";
						idxArr[x][y+1] += " R";
						answer++;
					}
				}

				break;
			case 'R':

				if (y + 1 <= 10) {

					y += 1;

					if (idxArr[x][y].contains(" R")) {
						break;
					} else {
						idxArr[x][y] += " R";
						idxArr[x][y-1] += " L";
						answer++;
					}
				}
				break;

			}

		}

		return answer;
	}
}