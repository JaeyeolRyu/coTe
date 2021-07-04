package coTe.ETC;

import java.math.BigInteger;

public class T3 {	

	static BigInteger min = new BigInteger("1000000007");
	static BigInteger MOD = new BigInteger("1000000007");

	public static void main(String[] args) {

		String num = "999999999999999999999999999999999999999999999999999999999999";
		int k = 6;
		int ans = solution(num, k);
		System.out.println(ans);

	}

	public static int solution(String num, int k) {

		int len = num.length();
		int[] combArr = new int[k];

		combination(combArr, len, 0, 1, k, num);

		
		int answer = min.intValue();

		return answer;
	}

	public static void combination(int[] combArr, int len, int depth, int idx, int remain, String num) {

		
		if (remain == 0) {

			BigInteger sum = BigInteger.ZERO;
			int left = 0;
			
			for (int i = 0; i < combArr.length; i++) {
				
				BigInteger tempNum = new BigInteger(num.substring(left, combArr[i]));
				sum.add(tempNum.remainder(MOD));
				left = combArr[i];

			}
			BigInteger tempNum = new BigInteger(num.substring(left));
			sum.add(tempNum.remainder(MOD));
			min = new BigInteger("" + Math.min(sum.remainder(MOD).intValue(), min.intValue()));

			return;

		} else if (idx == len) {
			return;
		} else {
			combArr[depth] = idx;
			combination(combArr, len, depth + 1, idx + 1, remain - 1, num);
			combination(combArr, len, depth, idx + 1, remain, num);
		}

	}

}
