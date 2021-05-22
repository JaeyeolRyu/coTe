package coTe.Pro.Level2;

class ProJadenCase {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (String str : s.split("")) {

			if (str.equals(" ")) {
				sb.append(str);
				isFirst = true;
				continue;
			} else if (isFirst) {
				sb.append(str.toUpperCase());
				isFirst = false;
			} else {
				sb.append(str.toLowerCase());
			}

		}

		return sb.toString();
	}
}