package coTe.Pro.Level2;

import java.util.Arrays;

class ProLCMOfN {

	public static void main(String[] args) {

		int[] arr = { 3, 4, 9, 16 };
		int ans = solution(arr);
		System.out.println(ans);
	}

	public static int solution(int[] arr) {

		Arrays.sort(arr);

		int b = arr[0];
		int c = 0;
		for (int i = 1; i < arr.length; i++) {

			int a = arr[i];

			if (a > b) {

				c = gcd(a, b);

			} else {

				c = gcd(b, a);

			}

			b = c * (a / c) * (b / c);
		}

		return b;
	}

	public static int gcd(int a, int b) {

		if (a % b == 0) {
			return b;
		}

		return gcd(b, a % b);
	}
}