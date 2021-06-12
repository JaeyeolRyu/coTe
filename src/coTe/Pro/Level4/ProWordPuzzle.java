package coTe.Pro.Level4;

import java.util.Arrays;

class ProWordPuzzle {

	public static void main(String[] args) {

		String[] strs = { "ba", "na", "n", "a" };
		String t = "banana";

		int ans = solution(strs, t);

		System.out.println(ans);

	}

	public static int solution(String[] strs, String t) {
		int answer = 0;

		int[] dp = new int[t.length()];
		Arrays.fill(dp, 20001);

		for (int i = 0; i < t.length(); i++) {

			char c = t.charAt(i);

			for (String str : strs) {

				if (str.charAt(str.length() - 1) == c) {

					if (str.length() > i+1) {
						continue;
					} else {

						if (str.length()-1 == i && str.equals(t.substring(0, i+1))) {
							dp[i] = 1;
						} else {
							boolean isSame = true;

							for (int j = 0; j < str.length(); j++) {
								if (str.charAt(str.length() - 1 - j) != t.charAt(i - j)) {
									isSame = false;
									break;
								}
							}

							if (isSame) {

								dp[i] = Math.min(dp[i], dp[i - str.length()] + 1);
								System.out.println("dp["+i+"] 값 : " + dp[i]);
							}
						}

					}

				}

			}

		}

		if (dp[t.length() - 1] == 20001) {
			return -1;
		} else {
			return answer = dp[t.length() - 1];
		}

	}
}