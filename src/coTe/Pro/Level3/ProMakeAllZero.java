package coTe.Pro.Level3;

import java.util.ArrayList;
import java.util.List;

class ProMakeAllZero {
	 
	static boolean[] visit;
	static List<Integer>[] nodeList;
	static long answer;
	static long[] calArr;
	
	public static void main(String[] args) {
		
		int[] a = {-5,0,2,1,2};
		int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
		
		long ans = solution(a, edges);
		
		System.out.println(ans);
		
	}
	public static long solution(int[] a, int[][] edges) {
        
		calArr = new long[a.length];
		answer = 0;
        nodeList = new ArrayList[a.length];
        visit = new boolean[a.length];
        
        int sum	= 0;
        
        for(int i = 0 ; i < a.length; i++) {
        	nodeList[i] = new ArrayList<>();
        	calArr[i] = a[i];
        	sum+= a[i];
        }
        if(sum != 0) {
        	return -1;
        }
        
        for(int[] edge : edges) {
        	
        	int num1 = edge[0];
        	int num2 = edge[1];
        	
        	nodeList[num1].add(num2);
        	nodeList[num2].add(num1);
        	
        }
        
        
       cal(0);
        
        return answer;
    }
    
    public static void cal(int num) {
    	
    	visit[num] = true;
    	
    	for(int i = 0; i < nodeList[num].size(); i++	 ) {
    		
    		int idx = nodeList[num].get(i);
    		
    		if(!visit[idx]) {
    			
    			visit[idx]	= true;
    			cal(idx);
    			calArr[num] += calArr[idx]; 
    	    	answer += Math.abs(calArr[idx]);
    		}
    		
    	}
    	
    }
    
}