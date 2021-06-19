package coTe.YGY;

import java.util.Arrays;

class YGY3 {
	
	public static void main(String[] args) {
		
		int U = 3;
		int L = 3;
		int[] C = {2,1,1,0,1};
		
		String ans = solution(U, L, C);
		
		System.out.println(ans);
		
		
	}
	
	public static String solution(int U, int L, int[] C) {

		int sum = 0;
		int cnt2 = 0;
		for (int i = 0; i < C.length; i++) {
			sum += C[i];
			if (C[i] == 2) {
				cnt2++;
			}
		}

		if (sum != (U + L)) {
			return "IMPOSSIBLE";
		}

		StringBuilder sbU = new StringBuilder();
		StringBuilder sbL = new StringBuilder();

		U -= cnt2;
		L -= cnt2;

		for (int i = 0; i < C.length; i++) {

			if (C[i] == 2) {
				sbU.append("1");
				sbL.append("1");
			} else if (C[i] == 1) {

				if (U != 0) {
					sbU.append("1");
					sbL.append("0");
					U--;
				} else {
					sbU.append("0");
					sbL.append("1");
				}
			} else {
				sbU.append("0");
				sbL.append("0");
			}
		}

		return sbU.toString()+","+sbL.toString();

	}
}
