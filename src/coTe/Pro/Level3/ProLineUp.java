package coTe.Pro.Level3;

import java.util.Arrays;

class ProLineUp {

	static boolean[] visit;
	static long K;
	static int[] answer;

	public static int[] solution(int n, long k) {

		K = k;
		visit = new boolean[n + 1];
		answer = new int[n];
		int digit = 0;
		for (int i = n; i > 0; i--) {

			int temp = getNum(i);
			checkVisit(temp, digit++);
		}

		return answer;
	}

	public static int getNum(int num) {

		int idx = 1;

		long cal = 1;
		for (int i = num - 1; i > 0; i--) {
			cal *= i;
		}

		while (K > cal) {

			K -= cal;
			idx++;

		}

		return idx;

	}

	public static void checkVisit(int temp, int digit) {

		int idx = 1;
		while (temp != 0) {

			if (!visit[idx]) {
				temp--;
			}
			idx++;
		}

		visit[idx - 1] = true;
		answer[digit] = idx - 1;

	}
}