package coTe.Pro;

class ProExpressionOfNumber {
	public int solution(int n) {
		int answer = 0;
		int idx = 1;
		while (idx != n + 1) {
			int temp = 0;

			for (int i = idx; i < n + 1; i++) {

				temp += i;

				if (temp == n) {
					answer++;
					break;
				} else if (temp > n) {
					break;
				}

			}

			idx++;
		}

		return answer;
	}
}