package coTe.Pro.Level1;

import java.util.ArrayList;
import java.util.List;

class ProPrimeFail {

	List<Integer> numList = new ArrayList<Integer>();

	public int solution(int n) {

		for (int i = 2; i <= n; i++) {

			if (calc(i)) {
				numList.add(i);
			} else {
			}

		}

		return numList.size();
	}

	public boolean calc(int num) {

		for (int i = 0; i < numList.size(); i++) {

			if (num % numList.get(i) == 0) {
				return false;
			}

		}

		return true;
	}
}