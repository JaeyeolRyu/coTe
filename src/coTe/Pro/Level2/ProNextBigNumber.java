package coTe.Pro.Level2;

class ProNextBigNumber {
	public int solution(int n) {
		
		int oneCnt = Integer.toBinaryString(n).replace("0", "").length();

		while (true) {

			n++;

			int tempCnt = Integer.toBinaryString(n).replace("0", "").length();

			if (tempCnt == oneCnt) {

				break;

			}

		}

		return n;
	}
}