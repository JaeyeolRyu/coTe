package coTe.Pro.Level1;

class ProCntPY {
	boolean solution(String s) {
		boolean answer = true;

		int pCnt = 0;
		int yCnt = 0;

		for (char c : s.toCharArray()) {

			if (c == 'p' || c == 'P') {
				pCnt++;
			} else if (c == 'y' || c == 'Y') {
				yCnt++;
			}
		}

		if (pCnt != yCnt) {
			answer = false;
		}

		return answer;
	}
}