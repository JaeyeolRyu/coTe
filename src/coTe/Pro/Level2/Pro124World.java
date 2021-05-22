package coTe.Pro.Level2;

class Pro124World {
	public String solution(int n) {
		String[] numeralSystem = { "4", "1", "2" };
		StringBuilder sb = new StringBuilder();
		String answer = "";

		while (n > 0) {

			sb.append(numeralSystem[n % 3]);

			if (n % 3 == 0) {

				n = (n / 3) - 1;
			} else {
				n /= 3;
			}

		}

		sb.reverse();
		answer = sb.toString();
		return answer;
	}
}