package coTe;

class KakaoCrossBridge {
	
	public static void main(String[] args) throws Exception {
		
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		int ans = solution(stones, k);
		
		System.out.println(ans);
	}
	
    public static int solution(int[] stones, int k) {
    	int answer = 0;
    	int start = Integer.MAX_VALUE;
    	int end = 0;
    	int mid = 0;
    	int cnt = 0;
    	boolean isPossible = true;
    	
    	for(int stone : stones) {
    		
    		start = Math.min(start, stone);
    		end = Math.max(end, stone);
    	}
    	
    	while(start <= end) {
    		isPossible = true;
    		mid = (start+end)/2;
    		cnt = 0;
    		
    		for(int i = 0; i < stones.length; i++) {

    			if(stones[i]-mid <= 0) {
    				cnt++;
    			} else {
    				cnt = 0;
    			}

    			if(cnt == k) {
    				isPossible = false;
    				break;
    			} 

        	}
    		
    		if(!isPossible) {
    			end = mid-1;
    			answer = mid;
    		} else {
    			start = mid+1;
    			
    		}
    		
    	}
    	
    	return answer;
    }
    
}