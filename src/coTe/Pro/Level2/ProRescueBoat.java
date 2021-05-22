package coTe.Pro.Level2;

import java.util.Arrays;

class ProRescueBoat {

	public static void main(String[] args) {

		int[] people = { 70, 50, 80, 50 };
		int limit = 100;

		int ans = solution(people, limit);
		System.out.println(ans);
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;

		int start = 0;
		int end = people.length - 1;

		Arrays.sort(people);

		while (start <= end) {

			if (people[end] + people[start] <= limit) {
				end--;
				start++;
				answer++;
			} else {
				end--;
				answer++;
			}

		}

		return answer;
	}
}