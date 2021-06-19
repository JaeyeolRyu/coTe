package coTe.Pro.Level4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class KakaoHealthBrianFail {
	
	public static void main(String[] args) {
		
		int n = 6;
		int m = 3;
		int[][] timetable = {{1140, 1200},
				{1140, 1200},{1140, 1200},{1140, 1200},{1140, 1200},{1140, 1200},
				{1140, 1200},{1140, 1200},{1140, 1200},{1140, 1200},{1140, 1200},{1140, 1200},{1140, 1200}};
		
		int ans = solution(n, m, timetable);
		System.out.println(ans);
		
		
	}
	public static int solution(int n, int m, int[][] timetable) {

		int answer = 0;

		Arrays.sort(timetable, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o2[0] - o1[0];
				}
				return o2[1] - o1[1];
			}
		});

		int[] maxArr = new int[1321];
		
		for(int i = 0; i < m; i ++) {
			
			int t1 = timetable[i][0];
			int t2 = timetable[i][1];
			
			for(int j = t1; j <= t2; j++) {
				maxArr[j]++;
			}
		}

		int max = 0;
		for(int i = 600; i <= 1320; i++	 ) {
			max = Math.max(maxArr[i], max);			
		}
		
		
		if (max == 1) {
			return 0;
		} else if (max == 2) {
			return 2 * n - 2;
		} else {

			for (int i = 1; i <= 2 * n - 2; i++) {
				
				for(int j = 0 ; j < n; j++) {
					if (checkMaxDistance(j, i, max, n)) {
						answer = i;
					}
				}
				
				if(answer != i) {
					break;
				}
			}
		}
		
		return answer;
	}

	public static boolean checkMaxDistance(int start, int dis, int people, int n) {

		List<Location> allotList = new ArrayList<>();
		boolean isPos = true;
		
		people--;
		allotList.add(new Location(start, 0));
		int x = start, y = 0;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				isPos = true;
				if (people == 0) {
					return true;
				}

				if (Math.abs(i - x) + Math.abs(j - y) >= dis) {

					for (int k = 0; k < allotList.size(); k++) {

						Location lo = allotList.get(k);

						if (Math.abs(i - lo.x) + Math.abs(j - lo.y) < dis) {
							isPos = false;
							break;
						}

					}

					if (isPos) {
						allotList.add(new Location(i, j));
						people--;
						x = i;
						y = j;
						
					}

				}

			}

		}

		return false;
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