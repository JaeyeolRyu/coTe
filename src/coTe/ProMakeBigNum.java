package coTe;

class ProMakeBigNum {

//	public static void main(String[] args) {
//
//		String number = "4177252841";
//
//		int k = 4;
//
//		String answer = solution(number, k);
//
//		System.out.println(answer);
//	}

	public static String solution(String number, int k) {
		String answer = "";

		StringBuffer str = new StringBuffer(number);

		for (int i = 0; i < str.length() - 1; i++) {

			if (str.charAt(i) < str.charAt(i + 1)) {

				str.deleteCharAt(i);
				i-=2;
				
				if(i == -2) {
					i = -1;
				}
				if (--k == 0) {
					break;
				}
			}

		}

		if (k > 0) {
			return str.substring(0, str.length() - k);
		} else {
			return str.toString();
		}

	}
}