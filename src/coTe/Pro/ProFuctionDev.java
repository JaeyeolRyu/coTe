package coTe.Pro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ProFuctionDev {
	
	public static void main(String[] args) { 
		
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		int[] ans = solution(progresses, speeds);
		System.out.println(Arrays.toString(ans));
	}
	
	
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		List<Integer> ansList = new ArrayList<Integer>();

		int idx = 0;
		boolean[] isFinish = new boolean[progresses.length];

		while (idx + 1 <= progresses.length) {

			for (int i = 0; i < progresses.length; i++) {

				progresses[i] += speeds[i];

				if (!isFinish[i] && progresses[i] >= 100) {

					isFinish[i] = true;
				}

			}

			if (isFinish[idx]) {
				int finishPro = 0;

				while (isFinish[idx]) {

					finishPro++;
					idx++;
					
					if(idx == progresses.length) {
						break;
					}
				}

				ansList.add(finishPro);
				

			}

		}

		answer = new int[ansList.size()];
		int num = 0;
		for (int temp : ansList) {

			answer[num++] = temp;

		}

		return answer;
	}
}