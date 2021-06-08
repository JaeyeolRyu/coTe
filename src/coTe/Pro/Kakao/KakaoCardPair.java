package coTe.Pro.Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class KakaoCardPair {

	static int[][] boards;
	static Map<Integer, List<Location>> cardMap = new HashMap<>();
	static int[] cardArr;
	static int[][] move = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	static boolean[] visit;
	static int INF = 987654321;
	static int min = INF;

	public static int solution(int[][] board, int r, int c) {
		boards = board;

		for (int i = 0; i < 4; i++) { // 좌표 담는 과정

			for (int j = 0; j < 4; j++) {

				int temp = board[i][j];
				if (temp != 0) {

					if (!cardMap.containsKey(temp)) {

						cardMap.put(temp, new ArrayList<>());
						cardMap.get(temp).add(new Location(i, j, 0));

					} else {

						cardMap.get(temp).add(new Location(i, j, 0));
					}

				}

			}

		}

		cardArr = new int[cardMap.size()];
		visit = new boolean[cardMap.size()];
		int idx = 0;
		Iterator<Integer> keySet = cardMap.keySet().iterator();

		while (keySet.hasNext()) { // 카드 번호 담는 과정

			cardArr[idx] = keySet.next();
			idx++;

		}

		combineCard(new int[cardArr.length], 0, cardArr.length, new Location(r, c, 0));

		return min;
	}

	public static void combineCard(int[] arr, int depth, int idx, Location lo) {

		if (depth == idx) {
			int cnt = decideTurns(arr, lo, 0);
			min = Math.min(cnt, min);
			return;
		}

		for (int i = 0; i < arr.length; i++) {

			if (!visit[i]) {

				visit[i] = true;
				arr[depth] = cardArr[i];
				combineCard(arr, depth + 1, idx, lo);
				visit[i] = false;

			}

		}

	}

	public static int decideTurns(int[] arr, Location lo, int idx) { // 각각 2번의 방법이 필요 어느쪽으로 갈지.

		if (idx == arr.length) {
			return 0;
		}

		int cnt = INF;

		List<Location> card = cardMap.get(arr[idx]);

		int case1 = bfs(lo, card.get(0)) + bfs(card.get(0), card.get(1)) + 2;
		int case2 = bfs(lo, card.get(1)) + bfs(card.get(1), card.get(0)) + 2;

		for (int i = 0; i < 2; i++) {

			boards[card.get(i).x][card.get(i).y] = 0;

		}

		cnt = Math.min(cnt, case1 + decideTurns(arr, card.get(1), idx + 1));
		cnt = Math.min(cnt, case2 + decideTurns(arr, card.get(0), idx + 1));

		for (int i = 0; i < 2; i++) {

			boards[card.get(i).x][card.get(i).y] = arr[idx];

		}

		return cnt;
	}

	public static int bfs(Location start, Location end) {

		boolean[][] visit = new boolean[4][4];
		Queue<Location> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {

			Location lo = q.poll();

			if (lo.x == end.x && lo.y == end.y) {

				return lo.dis;

			}

			for (int i = 0; i < move.length; i++) {

				int dx = lo.x + move[i][0];
				int dy = lo.y + move[i][1];

				if (dx < 0 || dx > 3 || dy < 0 || dy > 3) {
					continue;
				}

				if (!visit[dx][dy]) {

					visit[dx][dy] = true;
					q.add(new Location(dx, dy, lo.dis + 1));

				}

				for (int j = 0; j < 2; j++) {

					if (boards[dx][dy] != 0) {
						break;
					}

					if (dx + move[i][0] < 0 || dx + move[i][0] > 3 || dy + move[i][1] < 0 || dy + move[i][1] > 3) {
						break;
					}

					dx += move[i][0];
					dy += move[i][1];

				}

				if (!visit[dx][dy]) {

					visit[dx][dy] = true;
					q.add(new Location(dx, dy, lo.dis + 1));

				}

			}

		}

		return INF;

	}

	static class Location {

		int x;
		int y;
		int dis;

		public Location(int x, int y, int dis) {

			this.x = x;
			this.y = y;
			this.dis = dis;
		}

	}

}