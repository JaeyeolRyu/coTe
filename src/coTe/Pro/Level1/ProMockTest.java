package coTe.Pro.Level1;

import java.util.*;

class ProMockTest {

	public static void main(String[] args) {

		int[] answers = { 1, 3, 2, 4, 2 };

		int[] ans = solution(answers);

		System.out.println(Arrays.toString(ans));
	}

	public static int[] solution(int[] answers) {
		int[] answer = {};

		int[] person1 = { 1, 2, 3, 4, 5 };
		int[] person2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] person3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int cnt1, cnt2, cnt3;
		cnt1 = cnt2 = cnt3 = 0;

		for (int i = 0; i < answers.length; i++) {

			if (answers[i] == person1[i % 5]) {
				cnt1++;
			}
			if (answers[i] == person2[i % 8]) {
				cnt2++;
			}
			if (answers[i] == person3[i % 10]) {
				cnt3++;
			}

		}

		int maxCnt = Math.max(cnt1, Math.max(cnt2, cnt3));

		List<Integer> list = new ArrayList<Integer>();

		if (maxCnt == cnt1) {
			list.add(1);
		}
		if (maxCnt == cnt2) {
			list.add(2);
		}
		if (maxCnt == cnt3) {
			list.add(3);
		}

		Integer[] arr = list.toArray(new Integer[0]);
		return answer = Arrays.stream(arr).mapToInt(i -> i).toArray();

	}
}