package coTe;

class Solution {
	static int[][] board =	{{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{0, 0, 1, 1, 1}};
	
	public static void main( String[] args) {
		
		int ans = solution(board);
		System.out.println(ans);
		
	}
	public static int solution(int[][] board) {
		int answer = 0;
		//this.board = board;
		
		answer = findSquare(Math.min(board.length, board[0].length));
		
		return answer;
	}
	
	public static int findSquare(int size) {

		int idx = board.length-size;
		int x = 0;
		int y = 0;
		int j = 0;
		while(x <= idx) {
			
			for(int i = x; i < size+x; i++) {
				
				y = 0;
				
				while(y <= idx) {
					
					for(j = y; j < size+y; j++) {
						
						if(board[i][j] == 0) {
							
							break;
						}
						
					}
					if(j == size+y && i == size+x-1) {
						
						return size*size;
					}
					
					y++;
				}
		
			}
			x++;
		}
		
		return findSquare(size-1);
	}
	
}