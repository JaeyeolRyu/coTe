package coTe.Pro.Level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class ProPrinter {

	public static void main(String[] args) {

		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		int location = 0;

		int answer = solution(priorities, location);

		System.out.println(answer);

	}

	public static int solution(int[] priorities, int location) {
		int answer = 1;
		int idx = 0;
		Integer[] sortArr = Arrays.stream(priorities.clone()).boxed().toArray(Integer[]::new);

		Arrays.sort(sortArr, Comparator.reverseOrder());
		Queue<Integer> q = new LinkedList<Integer>();

		for (int num : priorities) {

			q.add(num);

		}

		while (!q.isEmpty()) {

			if (q.peek() == sortArr[idx]) {

				if (location == 0) {
					return answer;
				} else {

					location--;
					q.poll();
					answer++;
					idx++;
				}

			} else {

				q.add(q.poll());

				if (location == 0) {

					location = q.size() - 1;

				} else {
					location--;
				}
			}

		}
		return answer;
	}

}