package coTe.YGY;

import java.util.ArrayList;
import java.util.List;

class YGY1 {

	public static String solution(String S, String C) {

		StringBuilder sb = new StringBuilder();
		String mailFormat = "@" + C.toLowerCase() + ".com>, ";

		List<String> nameList = new ArrayList<String>();

		String[] nameArr = S.split(", ");

		for (int i = 0; i < nameArr.length; i++) {

			String mailId = "";
			sb.append(nameArr[i] + " <");

			String[] nameToLower = nameArr[i].toLowerCase().replace("-", "").split(" ");

			if (nameToLower.length == 3) { // has middle

				if (nameToLower[2].length() > 8) {

					mailId = nameToLower[0].charAt(0) + "" + nameToLower[1].charAt(0) + nameToLower[2].substring(0, 8);
				} else {
					mailId = nameToLower[0].charAt(0) + "" + nameToLower[1].charAt(0) + nameToLower[2];
				}

			} else {

				if (nameToLower[1].length() > 8) {
					mailId = nameToLower[0].charAt(0) + nameToLower[1].substring(0, 8);
				} else {
					mailId = nameToLower[0].charAt(0) + nameToLower[1];
				}

			}

			if (nameList.contains(mailId)) {

				int idx = 2;

				while (nameList.contains(mailId + String.valueOf(idx))) {
					idx++;
				}
				mailId = mailId + String.valueOf(idx);

			}

			nameList.add(mailId);
			sb.append(mailId + mailFormat);

		}

		sb.setLength(sb.length() - 2);

		return sb.toString();

	}
}
