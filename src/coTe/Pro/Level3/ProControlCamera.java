package coTe.Pro.Level3;

import java.util.Arrays;
import java.util.Comparator;

class ProControlCamera {
	
	public static void main(String[] args) {
		
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};	
		
		int ans = solution(routes);
		System.out.println(ans);
	}
	public static int solution(int[][] routes) {
		int answer = 1;

		Arrays.sort(routes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {

					return o2[1] - o1[1];
				} else {

					return o1[0] - o2[0];
				}
			}
		});

		int min = routes[0][0];
		int max = routes[0][1];

		for (int i = 1; i < routes.length; i++) {

			int enterPoint = routes[i][0];
			int exitPoint = routes[i][1];

			if (max < enterPoint) {

				min = enterPoint;
				max = exitPoint;
				answer++;
			} else {

				min = Math.max(min, enterPoint);
				max = Math.min(max, exitPoint);

			}

		}

		return answer;
	}
}