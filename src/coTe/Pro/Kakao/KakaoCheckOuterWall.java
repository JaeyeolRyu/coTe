package coTe.Pro.Kakao;

class KakaoCheckOuterWall {

	static boolean[] visit;
	static int[][] weakArr;
	static int min = -1;

	public static void main(String[] args) {

		int n = 12;
		int[] weak = { 1, 5, 6, 10 };
		int[] dist = { 1, 2, 3, 4 };

		int ans = solution(n, weak, dist);
		System.out.println(ans);

	}

	public static int solution(int n, int[] weak, int[] dist) {

		visit = new boolean[dist.length];

		weakArr = weakRotation(weak, n);

		for (int i = 1; i <= dist.length; i++) {

			int[] arr = new int[i];
			permutation(arr, dist, i, 0);

			if (min != -1) {
				return min;
			}
		}

		return min;
	}

	public static void permutation(int[] arr, int[] dis, int idx, int depth) {

		if (depth == idx) {

			if (possibility(arr)) {

				min = idx;

			}

			return;
		}

		for (int i = 0; i < dis.length; i++) {

			if (!visit[i]) {

				visit[i] = true;
				arr[depth] = dis[i];
				permutation(arr, dis, idx, depth + 1);
				visit[i] = false;

			}

		}

	}

	public static boolean possibility(int[] arr) {

		for (int i = 0; i < weakArr.length; i++) {

			int idx = 0;
			int startIdx = weakArr[i][0];

			for (int j = 0; j < arr.length; j++) {

				while (idx != weakArr.length) {

					if (startIdx + arr[j] >= weakArr[i][idx]) {

						idx++;

					} else {
						startIdx = weakArr[i][idx];
						break;
					}

				}

				if (idx == weakArr.length) {
					return true;
				}

			}

		}

		return false;
	}

	public static int[][] weakRotation(int[] weak, int n) {

		int[][] weakArr = new int[weak.length][weak.length];

		for (int i = 0; i < weak.length; i++) {

			int[] temp = new int[weak.length];
			int idx = 0;

			for (int j = i; j < i + weak.length; j++) {

				if (j < weak.length) {

					temp[idx] = weak[j % weak.length];
				} else {

					temp[idx] = weak[j % weak.length] + n;
				}

				idx++;

			}

			weakArr[i] = temp;
		}

		return weakArr;
	}

}