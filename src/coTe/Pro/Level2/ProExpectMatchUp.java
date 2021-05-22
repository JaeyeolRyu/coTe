package coTe.Pro.Level2;

class ProExpectMatchUp {
	public int solution(int n, int a, int b) {
		int answer = 0;

		while (true) {

			a = Math.round((float) a / 2);
			b = Math.round((float) b / 2);
			answer++;

			if (a == b) {
				break;
			}
		}

		return answer;
	}
}