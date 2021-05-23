package coTe.Pro.Level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ProFarthestNode2 {
	static int INF = 50001;
	static int[][] nodeArr;
	static int[] dis;
	static boolean[] visit;
	public static void main(String[] args) {

		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		int ans = solution(n, edge);

		System.out.println(ans);

	}

	public static int solution(int n, int[][] edge) {
		int answer = 0;
		dis = new int[n + 1];
		visit = new boolean[n + 1];
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
		
		for (int i = 1; i < n + 1; i++) { 
			
			dis[i] = INF;
		}
		
		dis[1] = 0;
		answer = search(1, n);

		return answer;
	}

	public static int search(int start, int n) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(1, dis[start]));
		
		while(!pq.isEmpty()) {
			
			Node node = pq.poll();
			int dist = node.dis;
			int idx = node.idx;
			
			if(dist > dis[idx]) {
				continue;
			}
			
			for(int i = 1; i < n+1; i++) {
				if(nodeArr[idx][i] != 0 && dis[i] > dis[idx] + nodeArr[idx][i]) {
					
					dis[i] = dis[idx] + nodeArr[idx][i];
					pq.add(new Node(i, dis[i]));
					
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
	
	static class Node implements Comparable<Node> {
		
		int idx;
		int dis;
		
		Node(int idx, int dis) {
			
			this.idx = idx;
			this.dis = dis;
			
		}

		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis;
		}
		
	}
}
