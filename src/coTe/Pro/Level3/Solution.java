package coTe.Pro.Level3;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	static int[] parent;

	public static void main(String[] args) {
		
		int n = 5;
		int[][] costs = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}};
		
		int ans = solution(n, costs);
		
		System.out.println(ans);
		
	}
	
	public static int solution(int n, int[][] costs) {
		int answer = 0;
		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		Arrays.sort(costs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		for (int[] cost : costs) {
			System.out.print(cost[0] + " " + findParent(cost[0])+" ");
			System.out.println(cost[1] + " " + findParent(cost[1]));
			if (findParent(cost[0]) == findParent(cost[1])) {
				continue;
			}
			answer += cost[2];
			updateParent(cost[0], cost[1]);
			
		}

		return answer;
	}

	public static int findParent(int idx) {
		
		if(parent[idx] == idx) {
			return idx;
		} 
		
		return parent[idx] = findParent(parent[idx]);
	}
	
	
	public static void updateParent(int idx1, int idx2) {

		int p1 = findParent(idx1);
		int p2 = findParent(idx2);
		
		if(p1 < p2) {
			parent[p2] = p1;
		} else {
			parent[p1] = p2;
		}
	}
}