package coTe.Pro.Level4;

import java.util.ArrayList;
import java.util.List;

class KakaoHealthBrian {

	static int[] canPeople;

	public static void main(String[] args) {

		int n = 8;
		int m = 4;
		int[][] timetable = { { 607, 610 }, { 607, 610 }, { 608, 610 }, { 609, 610 } };

		int ans = solution(n, m, timetable);
		System.out.println(ans);

	}

	public static int solution(int n, int m, int[][] timetable) {

		canPeople = new int[n * 2 - 2];
		int answer = 0;

		int[] maxArr = new int[1321];

		for (int i = 0; i < m; i++) {

			int t1 = timetable[i][0];
			int t2 = timetable[i][1];

			for (int j = t1; j <= t2; j++) {
				maxArr[j]++;
			}
		}

		int max = 0;
		for (int i = 600; i <= 1320; i++) {
			max = Math.max(maxArr[i], max);
		}

		canPeople[0] = n * n;
		canPeople[1] = (n * n + 1) / 2;
		if (max == 1) {
			return 0;
		} else if (max == 2) {
			return 2 * n - 2;
		} else {

			for (int i = 2; i < 2 * n - 2; i++) {

				for (int j = 0; j < n; j++) {
					checkMaxDistance(j, i, max, n);
				}

			}

			for (int i = 0; i < canPeople.length; i++) {
				if (canPeople[i] >= max) {
					answer++;
				} else {
					break;
				}
			}

		}

		return answer;
	}

	public static void checkMaxDistance(int start, int dis, int people, int n) {

		List<Location> allotList = new ArrayList<>();
		boolean isPos = true;
		allotList.add(new Location(0, start));

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				isPos = true;

				for (int k = 0; k < allotList.size(); k++) {

					Location lo = allotList.get(k);

					if (Math.abs(i - lo.x) + Math.abs(j - lo.y) <= dis) {
						isPos = false;
						break;
					}

				}

				if (isPos) {
					allotList.add(new Location(i, j));
				}

			}

		}

		canPeople[dis] = Math.max(canPeople[dis], allotList.size());
	}

	static class Location {

		int x;
		int y;

		public Location(int x, int y) {

			this.x = x;
			this.y = y;
		}

	}
}