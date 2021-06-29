package coTe.Pro.Level1;

public class ProCaesarCipher {

	public String solution(String s, int n) {
		String answer = "";

		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {

			if (c == ' ') {
				sb.append(" ");
			} else {

				if (c >= 'a' && c <= 'z') {

					c += n;

					if (c > 'z') {
						c -= 26;
					}

					sb.append(c);
				} else {

					c += n;

					if (c > 'Z') {
						c -= 26;
					}

					sb.append(c);
				}

			}

		}

		answer = sb.toString();

		return answer;
	}

}
