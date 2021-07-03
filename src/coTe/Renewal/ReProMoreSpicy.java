package coTe.Renewal;

import java.util.PriorityQueue;

public class ReProMoreSpicy {
	public int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Long> scoQ = new PriorityQueue<>();

		for (int sco : scoville) {
			scoQ.add((long) sco);
		}

		while (scoQ.size() > 1) {

			long lowest = scoQ.poll();
			long lower = scoQ.poll();

			if (lowest >= K) {
				return answer;
			} else {

				long newSco = lowest + (lower * 2);
				scoQ.add(newSco);
				answer++;

			}

		}

		if (scoQ.poll() >= K) {
			return answer;
		} else {
			return -1;
		}

	}
}
