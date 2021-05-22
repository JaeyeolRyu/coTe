package coTe.Pro.Level2;

import java.util.PriorityQueue;

class ProDelivery2 {
	static int INF = 500000 * 50;
	static int[][] cost;
	static int[] dis;
	
	public static void main(String[] args) {
		
		int N = 5;
		int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
		int K = 3;
		
		int ans = solution(N, road, K);
		
		System.out.println(ans);
	}
	public static int solution(int N, int[][] road, int K) {
		int answer = 0;
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
		
		for (int i = 1; i < N + 1; i++) { // 시작지점에서 i지점까지 갈때의 값을 dis배열에 저장해줌 (바로 이어져 있지않으면 INF값이 들어감)

			dis[i] = INF;
		}
		dis[1] = 0;
		answer = dijkstra(1, N, K);

		return answer;
	}

	public static int dijkstra(int start, int N, int K) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(1, dis[start]));
		
		while(!pq.isEmpty()) {
			
			Node node = pq.poll();
			int dist = node.dis;
			int idx = node.idx;
			
			if(dist > dis[idx]) {
				continue;
			}
				
			for(int i = 1; i < N+1; i++) {
				if(cost[idx][i] != 0 && dis[i] > dis[idx] + cost[idx][i]) {
					
					dis[i] = dis[idx] + cost[idx][i];
					pq.add(new Node(i, dis[i]));
					
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
	
	static class Node implements Comparable<Node> {
		
		int idx;
		int dis;
		
		Node(int idx, int dis) {
			
			this.idx = idx;
			this.dis = dis;
			
		}

		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis ;
		}
		
	}
}