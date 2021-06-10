package coTe.Pro.Level1;

import java.util.Arrays;

class Solution {
	public int solution(int[] d, int budget) {
		int answer = 0;
		int idx = 0;
		Arrays.sort(d);

		while (answer < d.length && budget >= d[idx]) {
			budget -= d[idx];
			idx++;
			answer++;
		}

		return answer;
	}
}