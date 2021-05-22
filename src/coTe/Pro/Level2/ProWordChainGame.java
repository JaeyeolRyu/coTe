package coTe.Pro.Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ProWordChainGame {
	
	public static void main(String[] args) {
		
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		
		int[] ans = solution(n, words);
		System.out.println(Arrays.toString(ans));
	}
	public static int[] solution(int n, String[] words) {
		int[] answer = new int[2];

		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		int personIdx = 1;
		int turnIdx = 1;
		char lastLetter = ' ';
		for (String str : words) {
			
			if(wordMap.isEmpty()) {
				
				wordMap.put(str, 0);
				lastLetter = str.charAt(str.length()-1);
				personIdx++;
				continue;
			}
			
			if (wordMap.containsKey(str) || str.charAt(0) != lastLetter) {
				answer[0] = personIdx;
				answer[1] = turnIdx;
				return answer;
			} else {
				wordMap.put(str, 0);
				lastLetter = str.charAt(str.length()-1);

				personIdx++;

				if (personIdx > n) {
					personIdx -= n;
					turnIdx++;
				}

			}

		}

		answer[0] = 0;
		answer[1] = 0;

		return answer;
	}
}