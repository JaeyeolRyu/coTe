package coTe.Pro.Level1;

public class ProMakeStrangeStr {
	
	public String solution(String s) {

		s = s.toLowerCase();

		StringBuilder sb = new StringBuilder();
		int idx = 0;

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == ' ') {
				sb.append(' ');
				idx = 0;
			} else {

				char c = s.charAt(i);

				if (idx % 2 == 0) {
					sb.append(String.valueOf(c).toUpperCase());
				} else {
					sb.append(c);
				}
				idx++;
			}

		}

		return sb.toString();
	}
}
