package coTe.Pro.Level3;

class ProPalindrome {
	String s;

	public int solution(String s) {
		int answer = 0;
		this.s = s;

		if (s.length() == 1) {
			return 1;
		}

		for (int i = 1; i < s.length(); i++) {

			int evenCnt = checkEven(i);
			int oddCnt = checkOdd(i);

			if (answer < evenCnt) {
				answer = evenCnt;
			}
			if (answer < oddCnt) {
				answer = oddCnt;
			}

		}

		return answer;
	}

	public int checkEven(int idx) {

		int cnt = 0;

		int i = 1;

		while (idx - i >= 0 && idx + i - 1 < s.length()) {

			if (s.charAt(idx - i) != s.charAt(idx + i - 1)) {
				return cnt * 2;
			}
			cnt++;
			i++;
		}

		return cnt * 2;

	}

	public int checkOdd(int idx) {

		int cnt = 0;

		int i = 1;

		while (idx - i >= 0 && idx + i < s.length()) {

			if (s.charAt(idx - i) != s.charAt(idx + i)) {
				return cnt * 2 + 1;
			}
			cnt++;
			i++;
		}

		return cnt * 2 + 1;

	}
}