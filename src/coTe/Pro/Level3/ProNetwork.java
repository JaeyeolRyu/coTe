package coTe.Pro.Level3;

import java.util.LinkedList;
import java.util.Queue;

class ProNetwork {
	
	static boolean[] visit;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
		int ans = solution(n, computers);
		
		System.out.println(ans);
		
	}
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        visit = new boolean[n];
        
        for(int i = 0 ; i < n ; i++) {
        	
        	if(!visit[i]) {
        		
        		answer++;
        		visit[i] = true;
        		q.add(i);
        		searchNetwork(n, computers);
        		
        	}
        	
        }
 
        return answer;
    }
    
    public static void searchNetwork(int n, int[][] computers) {
    	
    		while(!q.isEmpty()) {
	    		
	    		int idx = q.poll();
	        	
	        	for(int i = idx ; i < n ; i++) {
	        		
	        		if(!visit[i] && computers[idx][i] == 1) {
	        			visit[i] = true;
	        			q.add(i);
	        		}
	        		
	        	}
	        	
	    	}
    	    	
    }
    
}