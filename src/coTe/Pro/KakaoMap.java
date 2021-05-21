package coTe.Pro;

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

		for (int i = 0; i < n; i++) {  // 지도의 빈공간을 " "로 나타냈으므로 " "로 배열에 값을 넣어준다.
			for (int j = 0; j < n; j++) {

				map[i][j] = " "; 
			}

		}

		for (int i = 0; i < n; i++) { // 2진법으로 나타냈을때 1인부분에다가 #넣기
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