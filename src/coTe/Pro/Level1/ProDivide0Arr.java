package coTe.Pro.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ProDivide0Arr {
	public int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		List<Integer> numList = new ArrayList<>();

		for (int num : arr) {

			if (num % divisor == 0) {
				numList.add(num);
			}

		}

		if (numList.size() == 0) {
			numList.add(-1);
		} else {
			Collections.sort(numList);
		}

		answer = new int[numList.size()];
		for (int i = 0; i < numList.size(); i++) {

			answer[i] = numList.get(i);

		}

		return answer;
	}
}