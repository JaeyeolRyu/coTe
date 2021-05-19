package coTe;

import java.util.Arrays;

class ProStockPrice {
	
	public static void main(String[] args) {
		
		int[] prices = {1,2,3,2,3};
		int[] ans = solution(prices);
		System.out.println(Arrays.toString(ans));
		
	}
	
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int j = 0;
        for(int i = 0 ; i < prices.length-1; i++) {
        	
        	int cnt = 0;
        	
        	for(j = i; j < prices.length-1; j++) {
        		
        		if(prices[i] <= prices[j]) {
        			
        			cnt++;
        			
        		} else {
        			answer[i] = cnt;
        			break;
        		}
        		
        	}
        	
        	if(j == prices.length-1) {
        		answer[i] = cnt;
        	}
       	
        }
   
        return answer;
    }
}