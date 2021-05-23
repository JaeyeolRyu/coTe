package coTe.Pro.Level3;

import java.util.HashSet;
import java.util.Iterator;

class ProExpressionToN {

	@SuppressWarnings("unchecked")
	HashSet<Integer>[] dp = new HashSet[9];

	public int solution(int N, int number) {
		int answer = -1;

		if (N == number) {
			return 1;
		}

		for (int i = 0; i <= 8; i++) {

			dp[i] = new HashSet<>();
			String itN = "";

			for (int j = 1; j <= i; j++) {

				itN += String.valueOf(N);

			}
			
			if(i>0) {
				dp[i].add(Integer.parseInt(itN));
			}
			
			for (int j = 1; j < i; j++) {

				combination(j, i);

			}

			if (dp[i].contains(number)) {
				return i;
			}

		}

		return answer;
	}

	public void combination(int a, int b) {

		Iterator<Integer> list1 = dp[a].iterator();
		Iterator<Integer> list2 = dp[b - a].iterator();

		while (list1.hasNext()) {

			int temp1 = list1.next();

			while (list2.hasNext()) {
				int temp2 = list2.next();

				dp[b].add(temp1 + temp2);
				dp[b].add(temp1 - temp2);
				dp[b].add(temp1 * temp2);
				if(temp2 != 0) {
					dp[b].add(temp1 / temp2);
				}
				
			}
			list2 = dp[b - a].iterator();

		}

	}

}