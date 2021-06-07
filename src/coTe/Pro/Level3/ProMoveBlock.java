package coTe.Pro.Level3;

import java.util.LinkedList;
import java.util.Queue;

class ProMoveBlock {

	static boolean[][][] visit;
	static Queue<Location> q = new LinkedList<>();
	static int[][] Board;
	static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] checkRotation = { { -1, -1 }, { 1, 0 }, { -1, 0 }, { 1, -1 } };
	static int[][] insertPoint = { { 0, -1 }, { 1, 0 }, { 0, 0 }, { 1, -1 } };
	static int min = 987654321;

	public static int solution(int[][] board) {

		Board = board;
		visit = new boolean[board.length][board.length][2];

		q.add(new Location(0, 1, 0, 0));

		searchRoute();

		return min;
	}

	public static void searchRoute() { // dir 방향 0이 가로, 1이 세로.

		while (!q.isEmpty()) {

			Location lo = q.poll();
			if (lo.x == Board.length - 1 && lo.y == Board.length - 1) {

				min = Math.min(min, lo.dis);

			}

			if (!visit[lo.x][lo.y][lo.dir]) {

				visit[lo.x][lo.y][lo.dir] = true;

				if (lo.dir == 0) {

					for (int i = 0; i < move.length; i++) {

						int x1 = lo.x + move[i][0];
						int y1 = lo.y + move[i][1];
						int y2 = y1 - 1;

						if (x1 >= 0 && x1 < Board.length && y2 >= 0 && y1 < Board.length) {

							if (Board[x1][y1] == 0 && Board[x1][y2] == 0) {

								q.add(new Location(x1, y1, lo.dir, lo.dis + 1));

							}
						}

					}

					for (int i = 0; i < checkRotation.length; i++) {

						int dx = lo.x + checkRotation[i][0];
						int dy = lo.y + checkRotation[i][1];
						int nx = lo.x + checkRotation[(i + 2) % 4][0];
						int ny = lo.y + checkRotation[(i + 2) % 4][1];

						if (dx >= 0 && dx < Board.length && dy >= 0 && dy < Board.length) {

							if (Board[dx][dy] == 0 && Board[nx][ny] == 0) {

								int x = lo.x + insertPoint[i][0];
								int y = lo.y + insertPoint[i][1];

								q.add(new Location(x, y, 1, lo.dis + 1));

							}
						}

					}

				} else { // dir == 1 일 경우

					for (int i = 0; i < move.length; i++) {

						int x1 = lo.x + move[i][0];
						int y1 = lo.y + move[i][1];
						int x2 = x1 - 1;

						if (y1 >= 0 && y1 < Board.length && x2 >= 0 && x1 < Board.length) {

							if (Board[x1][y1] == 0 && Board[x2][y1] == 0) {

								q.add(new Location(x1, y1, lo.dir, lo.dis + 1));

							}
						}

					}

					for (int i = 0; i < checkRotation.length; i++) {

						int dx = lo.x + checkRotation[i][1]; // 돌릴때 새로 확인해야하는 좌표
						int dy = lo.y + checkRotation[i][0];
						int nx = lo.x + checkRotation[(i + 2) % 4][1]; // nx, ny는 회전방향에 벽이 있는지 여부 체크하는 좌표
						int ny = lo.y + checkRotation[(i + 2) % 4][0];

						if (dx >= 0 && dx < Board.length && dy >= 0 && dy < Board.length) {

							if (Board[dx][dy] == 0 && Board[nx][ny] == 0) {

								int x = lo.x + insertPoint[i][1];
								int y = lo.y + insertPoint[i][0];

								q.add(new Location(x, y, 0, lo.dis + 1));

							}

						}

					}

				}

			}

		}

	}

	static class Location {

		int x;
		int y;
		int dir;
		int dis;

		public Location(int x, int y, int dir, int dis) {

			this.x = x;
			this.y = y;
			this.dir = dir;
			this.dis = dis;

		}

	}

}