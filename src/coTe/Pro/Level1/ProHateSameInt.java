package coTe.Pro.Level1;

import java.util.*;

public class ProHateSameInt {
	public int[] solution(int[] arr) {
		int[] answer = {};

		ArrayList<Integer> numList = new ArrayList<>();

		int idx = 10;

		for (int num : arr) {

			if (idx != num) {
				numList.add(num);
				idx = num;
			}

		}

		answer = new int[numList.size()];

		for (int i = 0; i < numList.size(); i++) {
			answer[i] = numList.get(i);
		}

		return answer;
	}
}