package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dongjuk10 {

	static int[] wine;
	static Integer[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		wine = new int[n+1];
		dp = new Integer[n+1];
		
		for(int i = 1; i < n+1 ; i++) {
			
			wine[i] = Integer.parseInt(br.readLine());
			
		}
		dp[0] = 0;
		dp[1] = wine[1];
		
		if(n > 1) {
			dp[2] = wine[1] + wine[2];
		}
		System.out.println(cal(n));
	}

	public static int cal( int num) { 

		if( dp[num] == null) {
			
			dp[num] = Math.max(Math.max(cal(num-2), cal(num-3) + wine[num-1]) + wine[num], cal(num-1));
			
		}
		
		return dp[num];
	}
	
	
}
