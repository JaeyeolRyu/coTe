package coTe.Pro;

import java.util.Arrays;

class ProRescueBoat2 {
	static int[] peopleArr;
	
	public static void main(String[] args) {
		
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		
		int ans = solution(people, limit);
		
		System.out.println(ans);
	}
	
	public static int solution(int[] people, int limit) {

		peopleArr = people;
		int answer = 0;
		
		
		for (int i = 0; i < people.length; i++) {

			int weight = peopleArr[i];
			peopleArr[i] = 0;
			Arrays.sort(peopleArr);
			int remainWeight = limit - weight;
			int idx = binarySearch(0, peopleArr.length-1, remainWeight);
			
			if (peopleArr[idx] <= remainWeight && people[idx] != 0) {
				peopleArr[idx] = 0;
				i++;
			}
			
			answer++;
		}

		return answer;
	}

	public static int binarySearch(int s, int e, int remain) {

		int start = s;
		int end = e;

		while (start <= end) {

			int mid = (start + end) / 2;

			if (remain < peopleArr[mid]) {

				end = mid - 1;

			} else {

				start = mid + 1;
			}

		}

		return end;
	}

}