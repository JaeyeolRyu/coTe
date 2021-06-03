package coTe.Pro.Level3;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	
	public static void main(String[] args) {
		
		int  n  = 99;
		int[] works = {2, 15, 22, 55, 55};
		
		long ans = solution(n, works);
		
		System.out.println(ans);
		
	}
    public static long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works) {
        	pq.add(work);
        }
        
        while(n != 0) {
        	
        	if(pq.peek() == 0) {
        		return 0;
        	}
        	
        	pq.add(pq.poll()-1);
        	n--;
        }
        
        while(!pq.isEmpty()) {
        	
        	answer += Math.pow(pq.poll(), 2);
        	
        }
        
        return answer;
    }
}