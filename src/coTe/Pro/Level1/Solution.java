package coTe.Pro.Level1;

class Solution {
	public String solution(int a, int b) {
		String answer = "";

		int idx = b - 1;

		int plusA = 1;
		while (plusA < a) {

			switch (plusA) {
			case 2:
				idx += 29;
				break;

			case 4:
				idx += 30;
				break;

			case 6:
				idx += 30;
				break;

			case 9:
				idx += 30;
				break;

			case 11:
				idx += 30;
				break;

			default:
				idx += 31;
				break;
			}

			plusA++;
		}

		switch (idx % 7) {

		case 0:
			answer = "FRI";
			break;

		case 1:
			answer = "SAT";
			break;

		case 2:
			answer = "SUN";
			break;

		case 3:
			answer = "MON";
			break;

		case 4:
			answer = "TUE";
			break;

		case 5:
			answer = "WED";
			break;

		case 6:
			answer = "THU";
			break;

		}

		return answer;
	}
}
