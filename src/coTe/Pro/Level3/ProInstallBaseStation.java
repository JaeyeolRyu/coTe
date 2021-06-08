package coTe.Pro.Level3;

class ProInstallBaseStation {

	public static void main(String[] args) {

		int n = 11;
		int[] stations = { 4, 11 };
		int w = 1;

		int ans = solution(n, stations, w);
		System.out.println(ans);
	}

	public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		int range = (2 * w) + 1;
		int startIdx = 1;
		int endIdx = 0;

		for (int station : stations) {

			endIdx = station - w - 1;

			if (endIdx >= startIdx) {
				if ((endIdx - startIdx + 1) % range != 0) {
					answer++;
				}
				answer += (endIdx - startIdx + 1) / range;
			}
			startIdx = station + w + 1;

		}

		if (n >= startIdx) {
			if ((n - startIdx + 1) % range != 0) {
				answer++;
			}
			answer += (n - startIdx + 1) / range;
		}

		return answer;
	}
}