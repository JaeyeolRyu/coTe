package coTe;

import java.util.Arrays;

class ProTriangleSnail {

	public static void main(String[] args) {

		int n = 4;
		int[] ans = solution(n);
		System.out.println(Arrays.toString(ans));

	}

	public static int[] solution(int n) {
		int total = n * (n + 1) / 2;
		int[] answer = new int[total];
		int x = -1;
		int y = 0;
		int idx = 1;
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {

				if (i % 3 == 0) {
					x++;
				} else if (i % 3 == 1) {
					y++;
				} else {
					x--;
					y--;
				}
				arr[x][y] = idx++;
			}
		}

		int num = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {

				answer[num] = arr[i][j];
				num++;
			}
		}

		return answer;
	}
}