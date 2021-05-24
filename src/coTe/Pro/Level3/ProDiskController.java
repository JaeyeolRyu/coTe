package coTe.Pro.Level3;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class ProDiskController {
	public int solution(int[][] jobs) {
		int answer = 0;
		int timeIdx = 0;
		int totalTime = 0;

		LinkedList<Job> waitingQ = new LinkedList<>();

		PriorityQueue<Job> procPQ = new PriorityQueue<>();

		for (int[] temp : jobs) {

			waitingQ.add(new Job(temp[0], temp[1]));

		}

		Collections.sort(waitingQ, new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				return o1.start - o2.start;
			}
		});

		timeIdx = waitingQ.peek().start;
		int cnt = 0;

		while (cnt < jobs.length) {

			while (!waitingQ.isEmpty() && waitingQ.peek().start <= timeIdx) {
				procPQ.offer(waitingQ.pollFirst());
			}

			if (!procPQ.isEmpty()) {

				Job job = procPQ.poll();
				timeIdx += job.time;
				totalTime += timeIdx - job.start;
				cnt++;

			} else {

				timeIdx++;

			}

		}
		answer = totalTime / jobs.length;

		return answer;
	}

	class Job implements Comparable<Job> {

		int start;
		int time;

		Job(int start, int time) {

			this.start = start;
			this.time = time;

		}

		@Override
		public int compareTo(Job o) {
			return this.time - o.time;
		}

	}
}
