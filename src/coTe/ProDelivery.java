package coTe;

class ProDelivery {
	static int INF = 500000 * 50;
	static int[][] cost;
	static int[] dis;
	static boolean[] visit;
	
	public static void main(String[] args) {
		
		int N = 5;
		int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
		int K = 3;
		
		int ans = solution(N, road, K);
		
	}
	public static int solution(int N, int[][] road, int K) {
		int answer = 0;
		visit = new boolean[N + 1];
		dis = new int[N + 1];
		cost = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {

			for (int j = 1; j < N + 1; j++) { // 문제에서 주어진 최대값 이상의 값으로 초기화해줌.

				cost[i][j] = INF;

			}
			cost[i][i] = 0;
			
		}

		for (int[] temp : road) {
			
			if(cost[temp[0]][temp[1]] > temp[2]) {
				
				cost[temp[0]][temp[1]] = temp[2];
				cost[temp[1]][temp[0]] = temp[2];

			}
			
		}

		answer = dijkstra(1, N, K);

		return answer;
	}

	public static int dijkstra(int start, int N, int K) {

		for (int i = 1; i < N + 1; i++) { // 시작지점에서 i지점까지 갈때의 값을 dis배열에 저장해줌 (바로 이어져 있지않으면 INF값이 들어감)

			dis[i] = cost[start][i];
		}
		
		visit[start] = true;	// 위에서 시작지점으로 부터 거리를 넣어 줬으므로 시작지점의 visit값을 true로 바꿔줌. 

		for (int i = 0; i < N-2 ; i++) { // 총 N번을 돌아야하지만 위에서 start지점은 해줬으니 -1, 거리가 가장 긴 마지막 dis는 다른 지점들을 모두 탐색했으므로 visit가 다 true이므로 돌필요가 없으니 -1해서 총 N-2

			int min = INF; // min값 초기화
			int idx = 0; // 최소거리의 인덱스를 넣음.

			for (int j = 1; j < N + 1; j++) {

				if (!visit[j] && dis[j] < min) {
					min = dis[j];
					idx = j;
				}
			}
			visit[idx] = true;

			for (int j = 1; j < N + 1; j++) {

				if (!visit[j]) {

					if (dis[idx] + cost[idx][j] < dis[j]) {

						dis[j] = dis[idx] + cost[idx][j];

					}

				}
			}
			
		}
		
		int cnt = 0;
		for(int i = 1; i < N+1; i++) {
			
			if(dis[i] <= K) {
				cnt++;
			}
		}

		return cnt;
	}
}