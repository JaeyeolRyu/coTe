package coTe.Pro.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ProReverseString {
	public String solution(String s) {

		List<Character> lowerList = new ArrayList<>();
		List<Character> upperList = new ArrayList<>();

		for (char c : s.toCharArray()) {

			if (c >= 'a' && c <= 'z') {
				lowerList.add(c);
			} else {
				upperList.add(c);
			}

		}
		
		Collections.sort(upperList, Collections.reverseOrder());
		Collections.sort(lowerList, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();

		for (char c : lowerList) {
			sb.append(c);
		}
		for (char c : upperList) {
			sb.append(c);
		}

		return sb.toString();
	}
}