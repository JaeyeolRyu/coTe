package coTe.Pro.Level2;

import java.util.Arrays;

class ProMatrixRotation {
	static int[][] board;
	
	public static void main(String[] args) {
		
		int rows = 6;
		int columns	= 6;
		int[][]	queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
		
		int[] answer = solution(rows, columns, queries);
		
		System.out.println(Arrays.toString(answer));
		
	}
	
	
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        board = new  int[rows][columns];
        
        int num = 1;
        
        for(int i = 0; i < rows; i++) {
        	for(int j = 0 ; j < columns; j++) {
        		
        		board[i][j] = num++;
        		
        	}
        	
        }
        
        int idx = 0;
        for(int[] query : queries) {
        	
        	answer[idx++] = rotation(query);
        	
        }
        
        return answer;
    }
    
    public static int rotation(int[] query) {
    	
    	int x1 = query[0]-1;  
    	int y1 = query[1]-1;  
    	int x2 = query[2]-1;  
    	int y2 = query[3]-1;  
    	int temp = board[x1][y1];
    	int temp2 = 0;
    	int min = Integer.MAX_VALUE;
    	
    	for(int i = y1; i < y2; i++) { // 오른쪽 방향
    		
    		temp2 = board[x1][i+1];
    		board[x1][i+1] = temp;
    		temp = temp2;
    		min = Math.min(min, temp);
    		
    	}
    	
    	for(int i = x1; i < x2; i++) { // 아래 방향
    		
    		temp2 = board[i+1][y2];
    		board[i+1][y2] = temp;
    		temp = temp2;
    		min = Math.min(min, temp);
    	}
    	
    	for(int i = y2; i > y1; i--) { // 왼쪽방향
    		
    		temp2 = board[x2][i-1];
    		board[x2][i-1] = temp;
    		temp = temp2;
    		min = Math.min(min, temp);
    	}
    	
    	for(int i = x2; i > x1; i--) { // 위 방향
    		
    		temp2 = board[i-1][y1];
    		board[i-1][y1] = temp;
    		temp = temp2;
    		min = Math.min(min, temp);
    	}
    	
    	return min;
    }
    
}