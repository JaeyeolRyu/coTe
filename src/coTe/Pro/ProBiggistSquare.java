package coTe.Pro;

class ProBiggistSquare {
	int[][] board;
	int[][]	dp;

	public int solution(int[][] board) {
		int answer = 0;
		this.board = board;
		dp = new int[board.length][board[0].length];
		
		answer = findSquare();
		
		return answer;
	}
	
	public int findSquare() {
		int max = 0;
		for(int i = 0 ; i < dp.length; i++) {
			
			for(int j = 0 ; j < dp[0].length; j++) {
				
				if(i-1 < 0 || j-1 < 0) {
					dp[i][j] = board[i][j];
                    max = Math.max(dp[i][j], max);
				} else {
					if(board[i][j] == 1) {
						
						dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
						max = Math.max(dp[i][j], max);
						
					}

				}
				
			}

		}
		
		return (int)Math.pow(max, 2);
		
	}
	
}