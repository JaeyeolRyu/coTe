package coTe;

class KakaoMap {

//	public static void main(String[] args) throws Exception {
//
//		int n = 5;
//		int[] arr1 = { 9, 20, 28, 18, 11 };
//		int[] arr2 = { 30, 1, 21, 17, 28 };
//		String[] answer = new String[n];
//		answer = solution(n, arr1, arr2);
//
//		System.out.println(answer[0]);
//
//	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		StringBuilder sb;

		int map1;
		int temp;
		String[][] map = new String[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				map[i][j] = " ";
			}

		}

		for (int i = 0; i < n; i++) {
			temp = n - 1;

			map1 = (arr1[i] | arr2[i]);

			while (map1 > 0) {

				if ((map1 % 2) == 1) {
					map[i][temp] = "#";
				}
				map1 /= 2;
				temp--;
			}
		}

		for (int i = 0; i < n; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < n; j++) {

				sb.append(map[i][j]);
			}
			answer[i] = sb.toString();
		}

		return answer;
	}
}