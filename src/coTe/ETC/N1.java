package coTe.ETC;
import java.util.Arrays;

class N1 {
	public int solution(int[] prices, int[] discounts) {

		int answer = 0;
		Arrays.sort(prices);
		Arrays.sort(discounts);
		int lastIdx = prices.length - 1;
		int discountIdx = discounts.length - 1;
		for (int i = lastIdx; i >= lastIdx - (discounts.length - 1); i--) {

			answer += prices[i] * (100 - discounts[discountIdx]) / 100;
			discountIdx--;
		}

		for (int i = lastIdx - (discounts.length - 1) - 1; i >= 0; i--) {
			answer += prices[i];
		}

		return answer;
	}
}