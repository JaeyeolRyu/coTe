package coTe.Pro.Level1;

import java.util.Arrays;

class ProLotto {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int[] cntArr = new int[2];
		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		
		for (int lotto : lottos) {

			if (lotto == 0) {
				cntArr[0]++;
				continue;
			}

			for (int win : win_nums) {
				if (win == lotto) {
					cntArr[0]++;
					cntArr[1]++;
				}
			}

		}

		for (int i = 0; i < 2; i++) {

			if (cntArr[i] <= 1) {
				answer[i] = 6;
			} else {
				answer[i] = 7 - cntArr[i];
			}
		}

		return answer;
	}
}