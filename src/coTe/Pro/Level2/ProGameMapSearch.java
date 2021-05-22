package coTe.Pro.Level2;

import java.util.LinkedList;
import java.util.Queue;

class ProGameMapSearch {

	int[] xx = { 0, 0, -1, 1 };
	int[] yy = { -1, 1, 0, 0 };
	boolean[][] visit;
	Queue<Location> q = new LinkedList<>();

	public int solution(int[][] maps) {
		int answer = 0;
		visit = new boolean[maps.length][maps[0].length];
		q.add(new Location(0, 0));

		answer = searchRoute(maps);

		return answer;
	}

	public int searchRoute(int[][] maps) {

		visit[0][0] = true;

		while (!q.isEmpty()) {

			Location lo = q.poll();

			for (int i = 0; i < xx.length; i++) {

				int dx = lo.x + xx[i];
				int dy = lo.y + yy[i];

				if (dx >= 0 && dy >= 0 && dx < maps.length && dy < maps[0].length) {

					if (maps[dx][dy] == 0) {
						continue;
					}

					if (!visit[dx][dy]) {

						maps[dx][dy] = maps[lo.x][lo.y] + 1;
						visit[dx][dy] = true;
						q.add(new Location(dx, dy));
					}

				}

			}
		}

		if (maps[maps.length - 1][maps[0].length - 1] == 1) {
			return -1;
		} else {
			return maps[maps.length - 1][maps[0].length - 1];
		}

	}

	class Location {

		int x;
		int y;

		public Location(int x, int y) {

			this.x = x;
			this.y = y;

		}

	}

}
