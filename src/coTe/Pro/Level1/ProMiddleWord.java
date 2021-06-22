package coTe.Pro.Level1;

class ProMiddleWord {
	public String solution(String s) {
		String answer = "";

		int idx = s.length() / 2;

		if (s.length() % 2 == 0) {

			answer = s.substring(idx - 1, idx+1);
		} else {

			answer = String.valueOf(s.charAt(idx));
		}

		return answer;
	}
}