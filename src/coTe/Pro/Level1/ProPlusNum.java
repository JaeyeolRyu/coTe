package coTe.Pro.Level1;

import java.util.*;

class ProPlusNum {
	public int[] solution(int[] numbers) {
		int[] answer = {};

		Set<Integer> numSet = new HashSet<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				numSet.add(numbers[i] + numbers[j]);
			}
		}
		List<Integer> numList = new ArrayList<Integer>(numSet);
		Collections.sort(numList);
		answer = new int[numList.size()];

		for(int i = 0 ; i < numList.size();i++) {
			answer[i] = numList.get(i);
		}
		
		return answer;
	}
}