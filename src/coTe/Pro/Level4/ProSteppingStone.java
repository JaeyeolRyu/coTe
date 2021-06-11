package coTe.Pro.Level4;

import java.util.Arrays;

class ProSteppingStone {
	public int solution(int distance, int[] rocks, int n) {

		Arrays.sort(rocks);

		return binarySearch(distance, rocks, n);
	}

	public int binarySearch(int distance, int[] rocks, int n) {

		int answer = 0;
		int start = 0;
		int mid = 0;
		int end = distance;

		while (start <= end) {

			mid = (start + end) / 2;
			int cnt = 0;
			int idx = 0; // 이전 돌의 위치

			for (int i = 0; i < rocks.length; i++) {

				if (rocks[i] - idx < mid) {
					cnt++;
				} else {
					idx = rocks[i];
				}

				if (distance - idx < mid) {
					cnt++;
				}

			}

			if (cnt <= n) { // n개의 이하로 돌을 빼도 mid(돌 사이의 거리)값을 만들 수 있다. 돌사이의 거리를 늘려야 함.

				if (answer < mid) {
					answer = mid;
				}
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return answer;
	}

}