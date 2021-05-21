package coTe.Pro;

class ProCompressAndCount {

	int zero = 0;
	int one = 0;
	int[][] arr;

	public int[] solution(int[][] arr) {
		this.arr = arr;
		int[] answer = new int[2];
		
		compression(0, arr.length, 0, arr.length, arr.length/2);

		answer[0] = zero;
		answer[1] = one;

		return answer;
	}

	public void compression(int x1, int x2, int y1, int y2, int comp) {

		int temp = arr[x1][y1];
		if (comp != 0) {

			for (int i = x1 ; i < x2; i++) {

				for (int j = y1 ; j < y2; j++) {

					if (temp != arr[i][j]) {

						compression(x1, x2 - comp, y1, y2 - comp, comp/2);
						compression(x1, x2-comp, y1+comp, y2, comp/2);
						compression(x1+comp, x2, y1, y2-comp, comp/2);
						compression(x1+comp, x2, y1+comp, y2, comp/2);
						
						return;
					}

				}

			}

		}

		if (temp == 1) {
			one++;
		} else {
			zero++;
		}

	}

}