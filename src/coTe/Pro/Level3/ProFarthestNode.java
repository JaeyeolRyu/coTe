package coTe.Pro.Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ProFarthestNode {
	static int[] dis;
	static boolean[] visit;
	static List<ArrayList<Integer>> list = new ArrayList<>();
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
	
		for(int i = 0; i < edge.length; i++) {
			
			list.add(new ArrayList<>());
			
		}
		
		for (int i = 0; i < edge.length; i++) {
			
			list.get(edge[i][0]).add(edge[i][1]);
			list.get(edge[i][1]).add(edge[i][0]);
			
		}

		answer = search(1, n);

		return answer;
	}

	public static int search(int start, int n) {

		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(1);
		visit[1] = true;
		
		while(!q.isEmpty()) {
			
			int idx = q.poll();
			
			for(int temp : list.get(idx) ) {
				
				if(!visit[temp]) {
					
					dis[temp] = dis[idx] + 1;
					visit[temp] = true;
					q.add(temp);
				}
				
			}
			
		}
		
		Arrays.sort(dis);
		int max = dis[dis.length-1];
		int cnt = 0;

		for (int i = dis.length-1 ; i >= 0; i--) {

			if (max == dis[i]) {
				cnt++;
			} else {
				break;
			}

		}

		return cnt;

	}

}