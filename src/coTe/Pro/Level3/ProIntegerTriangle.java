package coTe.Pro.Level3;

class ProIntegerTriangle {
	int[][] dp;
    public int solution(int[][] triangle) {
        
        dp = new int[triangle.length][triangle.length];
       
        
        for(int i = 0 ; i < triangle.length; i++) {
        	dp[triangle.length-1][i] = triangle[triangle.length-1][i];
        }
        
        cal( triangle.length-1 ,triangle);
        
        return dp[0][0];
    }
    
    public void cal(int idx, int[][] triangle) {
    	
    	if(idx == 0) {
    		return;
    	}
    	for(int i = 0; i < idx; i++) {
    		
    		dp[idx-1][i] = Math.max(dp[idx][i], dp[idx][i+1]) + triangle[idx-1][i];
    	}
    	
    	cal(idx-1, triangle);
    }
}