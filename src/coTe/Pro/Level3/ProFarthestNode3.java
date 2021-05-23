package coTe.Pro.Level3;

import java.util.Arrays;

public class ProFarthestNode3 {
	static int INF = 50001;
	static int[][] nodeArr;

	public static void main(String[] args) {

		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		int ans = solution(n, edge);

		System.out.println(ans);

	}

	public static int solution(int n, int[][] edge) {
		int answer = 0;

		nodeArr = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {

			for (int j = 1; j < n + 1; j++) {

				nodeArr[i][j] = INF;
			}
			nodeArr[i][i] = 0;
		}

		for (int i = 0; i < edge.length; i++) {

			nodeArr[edge[i][0]][edge[i][1]] = 1;
			nodeArr[edge[i][1]][edge[i][0]] = 1;

		}

		answer = search(1, n);

		return answer;
	}

	public static int search(int start, int n) {

		int[] dis = new int[n + 1];
		boolean[] visit = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {

			dis[i] = nodeArr[start][i];

		}

		visit[start] = true;

		for (int i = 0; i < n - 2; i++) {

			int min = INF;
			int idx = 0;

			for (int j = 1; j < n + 1; j++) {

				if (!visit[j] && dis[j] < min) {

					min = dis[j];
					idx = j;

				}

			}

			visit[idx] = true;

			for (int j = 1; j < n + 1; j++) {

				if (!visit[j]) {

					if (dis[idx] + nodeArr[idx][j] < nodeArr[start][j]) {

						dis[j] = dis[idx] + nodeArr[idx][j];

					}

				}

			}

		}

		Arrays.sort(dis);
		int max = 0;
		int cnt = 0;
		int maxIdx = 0;
		for (int i = dis.length - 1; i >= 0; i--) {

			if (dis[i] != INF) {

				maxIdx = i;
				max = dis[i];
				break;
			}
		}

		for (int i = maxIdx; i >= 0; i--) {

			if (max == dis[i]) {
				cnt++;
			} else {
				break;
			}

		}

		return cnt;

	}

}
