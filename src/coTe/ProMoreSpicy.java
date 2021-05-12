package coTe;

import java.util.PriorityQueue;

class ProMoreSpicy {
	
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> scoQ = new PriorityQueue<>();
        
        for(int temp : scoville) {
        	
        	scoQ.add(temp);
        	
        }
        
        
        while(scoQ.peek() <= K) {
        	
        	if(scoQ.size() == 1) {
        		return -1;
        	}
        	
	        int sco1 = scoQ.poll();
	        int sco2 = scoQ.poll();
	        
	        scoQ.add(sco1 + sco2*2);
	        answer++;
        }
        
        return answer;
    }
}