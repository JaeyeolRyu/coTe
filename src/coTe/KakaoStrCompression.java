package coTe;

class KakaoStrCompression {

	public static void main(String[] args) throws Exception {

		String s = "a";
		int answer = solution(s);

		System.out.println(answer);
	}

	public static int solution(String s) {

		if (s.length() == 1) {
			return 1;
		}

		int answer = 0;
		String str = s;
		int len = str.length();
		String tempStr = "";
		int tempCnt = 1;
		StringBuilder sb = new StringBuilder();
		int min = 1000;
		int i, j;

		for (i = 1; i <= len / 2; i++) {

			tempStr = str.substring(0, i);

			for (j = 1; j < len / i; j++) {

				if (tempStr.equals(str.substring(i * j, i * (j + 1)))) {
					tempCnt++;
				} else {

					if (tempCnt == 1) {
						sb.append(tempStr);
						tempStr = str.substring(i * j, i * (j + 1));
					} else {
						sb.append(tempCnt + tempStr);
						tempStr = str.substring(i * j, i * (j + 1));
						tempCnt = 1;
					}

				}

			}

			if (tempCnt == 1) {
				sb.append(tempStr + str.substring(i * j));
			} else {
				sb.append(tempCnt + tempStr + str.substring(i * j));
				tempCnt = 1;
			}

			min = Math.min(min, sb.length());
			System.out.println("min 문자열 = " + sb); // 각 문자열 확인용
			sb = new StringBuilder();

		}

		answer = min;

		return answer;
	}

}
