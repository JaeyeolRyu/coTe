package coTe.Pro;

import java.util.LinkedList;
import java.util.Queue;

class KakaoRacingRoad {
	
	static Queue<Location> q = new LinkedList<>();
	static int[] xx = {-1,0,0,1};  // 12번째끼리 직선, 34번째끼리 직선
	static int[] yy = {0,-1,1,0};
	static final int straight = 100;
	static final int corner = 600;
	
    public static void main(String[] args) throws Exception {
    	
    	int[][] board = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}};
    	
    	int answer = solution(board);
    	System.out.println(answer);
    	
    }
    
    public static int solution(int[][] board) {
        int answer = 0;
        
        q.offer(new Location(0, 0, -1, 0));
        
        answer = constructRoad(board);
        
        return answer;
    }
    
    public static int constructRoad(int[][] board) {
    	
    	while(!q.isEmpty()) {
    		
    		Location lo = q.poll();
    		
    		for(int i = 0; i < xx.length; i++) {
    			
    			int dx = lo.x + xx[i];
    			int dy = lo.y + yy[i];
    			int direct = lo.direct;
    			int cost = lo.cost;

    			if( dx >= 0 && dy >= 0 && dx < board.length && dy < board.length && board[dx][dy] != 1) {
    				
    				if(direct == -1) {
    					cost += straight;
    				} else if( direct == i ) {
    					cost += straight;
    				} else {
    					cost += corner;
    				}
    			
    				if(board[dx][dy] == 0 || board[dx][dy] >= cost) {
        				
        				board[dx][dy] = cost;
        				
        				q.add(new Location(dx, dy, i, cost));
        				
        			} 
    				
    			}
    			
    		}
    	}
    	
    	return board[board.length-1][board.length-1];
    }
    
    static class Location {
		
		int x;
		int y;
		int direct;
		int cost;
		
		Location(int x, int y, int direct, int cost){
			this.x = x;
			this.y = y;
			this.direct = direct;
			this.cost = cost;
			
		}
		
	}
}