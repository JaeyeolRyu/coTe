package coTe.Pro.Level3;

class ProBestSet {
	public int[] solution(int n, int s) {
		int[] answer = {};
		int len = n;
		if (s < n) {
			answer = new int[1];
			answer[0] = -1;
			return answer;
		} else {
			answer = new int[n];
		}

		for (int i = 0; i < len; i++) {
			int idx = s / n;

			if (s % n == 0) {

				for (int j = i; j < len; j++) {
					answer[j] = idx;
				}
				break;
			} else {
				answer[i] = s / n;
				s -= idx;
				n--;
			}

		}

		return answer;
	}
}