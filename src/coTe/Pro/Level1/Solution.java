package coTe.Pro.Level1;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public long solution(long n) {

		String[] strArr = String.valueOf(n).split("");

		Arrays.sort(strArr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return Integer.parseInt(o2) - Integer.parseInt(o1);
			}
		});

		StringBuilder sb = new StringBuilder();

		for (String str : strArr) {

			sb.append(str);

		}

		return Long.parseLong(sb.toString());
	}
}