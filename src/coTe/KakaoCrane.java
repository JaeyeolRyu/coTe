package coTe;

import java.io.IOException;
import java.util.Stack;

class KakaoCrane {
	
    public static int solution(int[][] board, int[] moves) {
        
    	int answer = 0;
        Stack<Integer> basket = new Stack<>();
        int craneIdx;
        int doll;
        for(int i = 0; i < moves.length; i++) {
   
        	craneIdx = moves[i]-1;
        	
        	for(int j = 0 ; j < board.length; j++) {
        		
	        	if( board[j][craneIdx] != 0) {
	        		
	            	doll = board[j][craneIdx];
	            	board[j][craneIdx] = 0;
	            
	            	if(basket.isEmpty()) {
	            		basket.push(doll);
	            		break;
	            	}	            	
	            	if( basket.peek() != doll) {
	            		basket.push(doll);
	            	} else {
	            		basket.pop();
	            		answer += 2;
	            	}
	        		
	        		break;
	        	}
        	}	
        }
        return answer;
    }
}