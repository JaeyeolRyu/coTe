package coTe.Pro.Level3;

class ProWordConversion {

	static int min = Integer.MAX_VALUE;
	static boolean[] visit;

	public static void main(String[] args) {

		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

		int ans = solution(begin, target, words);

		System.out.println(ans);

	}

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		int cnt = 0;
		visit = new boolean[words.length];

		for (int i = 0; i < words.length; i++) {

			if (target.equals(words[i])) {
				break;
			}
			cnt++;
		}
		if (cnt == words.length) {
			return answer;
		}

		findMinValue(begin, target, 0, 0, words);

		if (min == Integer.MAX_VALUE) {
			answer = 0;
		} else {
			answer = min;
		}

		return answer;
	}

	public static void findMinValue(String begin, String target, int depth, int ans, String[] words) {

		int cnt = 0;

		for (int j = 0; j < begin.length(); j++) {

			if (begin.charAt(j) != target.charAt(j)) {
				cnt++;
			}
		}

		if (cnt == 1) {
			min = Math.min(ans + 1, min);
			return;
		}

		for (int i = 0; i < words.length; i++) {

			if (!visit[i]) {

				cnt = 0;

				for (int j = 0; j < begin.length(); j++) {

					if (words[i].charAt(j) != begin.charAt(j)) {
						cnt++;
					}
				}
				if (cnt == 1) {
					String temp = begin;
					begin = words[i];
					visit[i] = true;
					findMinValue(begin, target, depth + 1, ans + 1, words);
					visit[i] = false;
					begin = temp;
				}

			}

		}

	}
}