package coTe.Pro.Level3;

import java.util.Collections;
import java.util.PriorityQueue;

class ProDoublePriorityQueue {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];

		PriorityQueue<Integer> minPq = new PriorityQueue<>();
		PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
		int cnt = 0;
		for (String str : operations) {

			String[] operation = str.split(" ");
			
			switch (operation[0]) {
			case "I":
				cnt++;
				minPq.add(Integer.parseInt(operation[1]));
				maxPq.add(Integer.parseInt(operation[1]));

				break;

			case "D":

				if (operation[1].equals("-1")) {

					if (!minPq.isEmpty()) {
						cnt = Math.max(0, --cnt);
						minPq.poll();
					}

				} else {

					if (!maxPq.isEmpty()) {
						cnt = Math.max(0, --cnt);
						maxPq.poll();

					}
				}

				break;
			}
			
			if(cnt == 0) {
				
				while(!minPq.isEmpty()) {
					minPq.poll();
				}
				while(!maxPq.isEmpty()) {
					maxPq.poll();
				}
			}
			
		}
		if (cnt == 0) {
			return answer;
		} else {

			answer[0] = maxPq.poll();
			answer[1] = minPq.poll();

		}

		return answer;
	}
}