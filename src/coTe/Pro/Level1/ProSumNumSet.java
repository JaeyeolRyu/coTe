package coTe.Pro.Level1;

class ProSumNumSet {
	public long solution(int a, int b) {
		long answer = 0;

		if (a > b) {
			int temp = a;
			a = b;
			b = temp;

		}

		for (int i = a; i <= b; i++) {
			answer += i;
		}

		return answer;
	}
}