package coTe.Pro.Level1;

import java.util.Arrays;

class ProGymClothes {

	public static void main(String[] args) {

		int n = 5;
		int[] lost = { 1, 2, 3 };
		int[] reserve = { 2, 3, 4 };

		int ans = solution(n, lost, reserve);

		System.out.println(ans);

	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		int idx = 0;

		Arrays.sort(lost);
		Arrays.sort(reserve);

		for (int j = 0; j < lost.length; j++) {

			int lostNum = lost[j];

			for (int i = idx; i < reserve.length; i++) {

				if (reserve[i] + 1 < lostNum) {
					continue;
				} else if (reserve[i] - 1 > lostNum) {
					break;
				} else {

					if (reserve[i] - 1 == lostNum && j + 1 < lost.length && reserve[i] == lost[j + 1]) {
						j++;
					} else if (reserve[i] + 1 == lostNum && i + 1 < reserve.length && reserve[i + 1] == lostNum) {
						i++;
					}
					idx = ++i;
					answer++;
					break;
				}

			}

		}

		return answer;
	}
}