package coTe.Pro.Level4;

class ProTheft {
	public int solution(int[] money) {
		int answer = 0;

		int[] dp1 = new int[money.length];
		int[] dp2 = new int[money.length];

		dp1[0] = dp1[1] = money[0];
		dp2[1] = money[1];
				
		for (int i = 2; i < money.length - 1; i++) {

			dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
			dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);

		}

		int idx = money.length - 1;

		dp2[idx] = Math.max(dp2[idx - 2] + money[idx], dp2[idx - 1]);

		answer = Math.max(dp1[idx - 1], dp2[idx]);

		return answer;
	}
}