package coTe.Pro.Level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	static char[][] map;
	static List<Character> cardList = new ArrayList<>();
	static Map<Character, String> idxMap = new HashMap<Character, String>();
	static int m;
	static int n;

	public static void main(String[] args) {

		int mm = 1;
		int nn = 12;
		String[] board = {"ACBDFGGFDBCA"};
		String ans = solution(mm, nn, board);

		System.out.println(ans);

	}

	public static String solution(int mm, int nn, String[] board) {
		String answer = "";
//        this.m = m;
//        this.n = n;

		m = mm;
		n = nn;

		map = new char[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
				if (!cardList.contains(map[i][j]) && board[i].charAt(j) != '*' && board[i].charAt(j) != '.') {

					cardList.add(map[i][j]);
					
					idxMap.put(map[i][j], i + " " + j);

				} else {

					idxMap.put(map[i][j], idxMap.get(map[i][j]) + " " + i + " " + j);

				}
			}
		}

		Collections.sort(cardList);
		int cardCnt = cardList.size();

		String ans = searchCard(0);

		if (ans.length() == cardCnt) {

			answer = ans;
		} else {
			answer = "IMPOSSIBLE";
		}

		return answer;
	}

	public static String searchCard(int start) {

		StringBuilder sb = new StringBuilder();

		for (int i = start; i < cardList.size(); i++) {

			if (cardList.get(i) != ' ') {
				char card = cardList.get(i);
				String[] idx = idxMap.get(card).split(" ");
				int x1 = Integer.parseInt(idx[0]);
				int y1 = Integer.parseInt(idx[1]);
				int x2 = Integer.parseInt(idx[2]);
				int y2 = Integer.parseInt(idx[3]);

				boolean isPossible = searchPair(x1, y1, x2, y2, card);

				if (isPossible) {

					map[x1][y1] = '.';
					map[x2][y2] = '.';
					cardList.remove(i);
					i = -1;
					sb.append(card);
				}
			}

		}
		return sb.toString();

	}

	public static boolean searchPair(int x1, int y1, int x2, int y2, char card) {

		boolean dir1 = true;
		boolean dir2 = true;

		for (int i = x1; i < x2; i++) {

			if (map[i + 1][y1] == card) {
				return true;
			} else if (map[i + 1][y1] != '.') {
				dir1 = false;
				break;
			}

		}

		if (dir1) { // dir1방향에서 x 좌표사이에 장애물 없는경우 y좌표 체크

			if (y1 < y2) {

				for (int i = y1; i < y2; i++) {

					if (map[x2][i + 1] == card) {
						return true;

					} else if (map[x2][i + 1] != '.') {
						break;
					}

				}

			} else {

				for (int i = y1; i > y2; i--) {

					if (map[x2][i - 1] == card) {
						return true;

					} else if (map[x2][i - 1] != '.') {
						break;
					}

				}

			}
		}
		// dir2방향 체크시작

		for (int i = x2; i > x1; i--) {

			if (map[i - 1][y2] == card) {
				return true;
			} else if (map[i - 1][y2] != '.') {
				dir2 = false;
				break;
			}

		}

		if (dir2) {

			if (y1 == y2) {
				return true;
			} else if (y1 < y2) {

				for (int i = y2; i > y1; i--) {

					if (map[x1][i - 1] == card) {
						return true;

					} else if (map[x1][i - 1] != '.') {
						break;
					}

				}

			} else {

				for (int i = y2; i < y1; i++) {

					if (map[x1][i + 1] == card) {
						return true;

					} else if (map[x1][i + 1] != '.') {
						break;
					}

				}

			}

		}
		
		return false;

	}

}