package coTe.Pro.Level3;

class Solution {

	static int cnt;
	static int[] col;

	public static void main(String[] args) {

		int n = 3;

		int ans = solution(n);
		System.out.println(ans);
	}

	public static int solution(int n) {
		int answer = 0;

		for (int i = 0; i < n; i++) {

			col = new int[n];
			col[0] = i;
			
			searchQueen(n, 1);

		}

		answer = cnt;
		return answer;
	}

	public static void searchQueen(int n, int row) {

		if (row == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {

			if (checkPossibility(i, row)) {
				col[row] = i;
				searchQueen(n, row + 1);
			}

		}

	}

	public static boolean checkPossibility(int idx, int row) {

		for (int i = 0; i < row; i++) {
			if (col[i] == idx || Math.abs(i - row) == Math.abs(col[i] - idx)) {
				return false;
			}
		}
		return true;
	}

}