package coTe.Pro.Level4;

class Kakao4IU {
	public int solution(int n) {
		int answer = 0;

		answer = Search(n, 0);

		return answer;
	}

	public int Search(int n, int plusCnt) {

		if (Math.pow(3, plusCnt / 2) > n || n < 3) {
			return 0;
		}

		int cnt = 0;

		if (n == 3) {
			if (plusCnt == 2) {
				return 1;
			} else {
				return 0;
			}
		}

		if (plusCnt >= 2 && n % 3 == 0) {
			cnt += Search(n / 3, plusCnt - 2);
		}
		cnt += Search(n - 1, plusCnt + 1);

		return cnt;
	}

}