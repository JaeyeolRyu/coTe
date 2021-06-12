package coTe.Pro.Level4;

import java.util.*;

class ProWordPuzzleTimeFail {
	static int ANSWER = Integer.MAX_VALUE;
	static Map<Character, List<String>> wordMap = new HashMap<Character, List<String>>();
	static int[] dp;
	public static void main(String[] args) {
		
		String[] strs = {"app","ap","p","l","e","ple","pp"};
		String t = "apple";
		
		int ans = solution(strs, t);
		System.out.println(ans);
		
	}

	public static int solution(String[] strs, String t) {
		int answer = -1;
		dp = new int[t.length()];
		for (String str : strs) {
			char temp = str.charAt(0);

			if (!wordMap.containsKey(str.charAt(0))) {

				wordMap.put(temp, new ArrayList<String>());
				wordMap.get(temp).add(str);

			} else {
				wordMap.get(temp).add(str);
			}
		}

		searchCnt(t, 0);
		if (ANSWER != Integer.MAX_VALUE) {
			answer = ANSWER;
		}

		return answer;
	}

	public static void searchCnt(String str, int cnt) {

		if (str.length() == 0) {
			ANSWER = Math.min(cnt, ANSWER);
			return;
		}
		char firstWord = str.charAt(0);

		List<String> wordList = wordMap.get(firstWord);

		for (int i = 0; i < wordList.size(); i++) {

			String word = wordList.get(i);
			boolean isPos = true;
			if (word.length() > str.length()) {
				continue;
			}

			for (int j = 0; j < word.length(); j++) {
				if (word.charAt(j) != str.charAt(j)) {
					isPos = false;
					break;
				}
			}

			if (isPos) {
				searchCnt( str.substring(word.length()), cnt + 1);
			}

		}

	}

}