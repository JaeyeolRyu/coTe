package coTe.Pro.Level3;

import java.util.List;

class Solution {
	int[] parent;
    public long solution(int[] a, int[][] edges) {
        long answer = -2;
        int[] cntIdx = new int[a.length];
        parent = new int[a.length];
//        List<Integer> 
        
        for(int i = 0 ; i < a.length; i++) {
        	parent[i] = i;
        }
        
        for(int[] edge : edges) {
        	
        	int num1 = edge[0];
        	int num2 = edge[1];
        	cntIdx[num1]++;
        	cntIdx[num2]++;

        	int x = find(num1);
        	int y = find(num2);
        	
        	if(x != y) {
        		union(num1, num2);
        	}
        	
        }
        
        
        
        
        
        
        
        
        
        return answer;
    }
    
    public int find(int idx) {
    	
    	if(parent[idx] == idx) {
    		return idx;
    	}
    	
    	return parent[idx] = find(parent[idx]);
    }
    
    public void union(int x, int y) {
    	
    	int p1 = find(x);
    	int p2 = find(y);
    	
    	if(p1 > p2) {
    		parent[p1] = p2;
    	} else {
    		parent[p2] = p1;
    	}
    	
    }
    
    
}