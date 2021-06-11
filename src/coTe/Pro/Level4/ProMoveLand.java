package coTe.Pro.Level4;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class ProMoveLand {

	static int cnt = 0;
	static int Height = 0;
	static int[][] Land;
	static int[][] move = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	static boolean[][] visit;
	static PriorityQueue<Location> ladderQ = new PriorityQueue<>();
	static Queue<Location> loQ = new LinkedList<>();
	
	public static void main(String[] args) {
		
		int[][] land ={{1, 4, 8, 10},
				{5, 5, 5, 5}, 
				{10, 10, 10, 10}, 
				{10, 10, 10, 20}}; 
		int height = 3;
		
		int ans = solution(land, height);
		
		System.out.println(ans);
		
	}
	public static int solution(int[][] land, int height) {

		Land = land;
		Height = height;
		visit = new boolean[land.length][land.length];
		visit[0][0] = true;
		loQ.add(new Location(0, 0, Land[0][0]));
		checkMap();

		return cnt;
	}

	public static void checkMap() {

		while (!loQ.isEmpty()) {

			Location lo = loQ.poll();

			for (int i = 0; i < 4; i++) {

				int dx = lo.x + move[i][0];
				int dy = lo.y + move[i][1];

				if (dx >= 0 && dy >= 0 && dx < Land.length && dy < Land.length) {

					if (!visit[dx][dy]) {

						if (Math.abs(lo.value - Land[dx][dy]) <= Height) {

							visit[dx][dy] = true;
							loQ.add(new Location(dx, dy, Land[dx][dy]));

						} else {
							ladderQ.add(new Location(dx, dy, Math.abs(lo.value - Land[dx][dy])));
						}

					}

				}

			}

		}

		if (ladderQ.isEmpty()) {
			return;
		} else {

			while (!ladderQ.isEmpty()) {

				Location tempLo = ladderQ.poll();

				if (!visit[tempLo.x][tempLo.y]) {

					cnt += tempLo.value;
					loQ.add(new Location(tempLo.x, tempLo.y, Land[tempLo.x][tempLo.y]));
					visit[tempLo.x][tempLo.y] = true;
					checkMap();
					break;
				}

			}

		}

	}

	static class Location implements Comparable<Location> {

		int x;
		int y;
		int value;

		public Location(int x, int y, int value) {

			this.x = x;
			this.y = y;
			this.value = value;

		}

		@Override
		public int compareTo(Location o) {
			return this.value - o.value;
		}

	}

}