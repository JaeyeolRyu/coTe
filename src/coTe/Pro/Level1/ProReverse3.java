package coTe.Pro.Level1;

class ProReverse3 {
	public int solution(int n) {
		int answer = 0;
		int multiNum = 1;
		StringBuilder reverseNum = new StringBuilder();
		while (n > 0) {
			reverseNum.append(n % 3);
			n /= 3;
		}
		
		for (int i = reverseNum.length() - 1; i >= 0; i--) {

			answer += (reverseNum.charAt(i) - '0') * multiNum;
			multiNum *= 3;
		}

		return answer;
	}
}
