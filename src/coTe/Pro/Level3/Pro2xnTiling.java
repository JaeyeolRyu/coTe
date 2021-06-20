package coTe.Pro.Level3;

class Pro2xnTiling {
	static int dp[];
	
	public static void main(String[] args) {
		
		int n = 1;
		System.out.println(solution(n));
	}
	
    public static int solution(int n) {
        
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        cal(n);
        return dp[n];
    }
    
    public static void cal(int num) {
    	
    	for(int i = 2; i < num+1; i++) {
    		
    		dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
    		
    	}
    }
}