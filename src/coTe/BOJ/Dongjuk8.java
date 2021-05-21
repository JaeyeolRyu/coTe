package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dongjuk8 {
	
	static Integer[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N+1];
		dp[1] = 0;
		System.out.println(cal(N));
		
	}

	public static int cal(int num) {
		
		if(dp[num] == null) {
			if(num%6 == 0) {
				dp[num] = Math.min(cal(num-1), Math.min(cal(num/2), cal(num/3))) + 1;
			} else if(num%3 == 0) {
				dp[num] = Math.min(cal(num/3), cal(num-1)) + 1;
			} else if(num%2 == 0) {
				dp[num] = Math.min(cal(num/2), cal(num-1)) + 1 ;
			} else {
				dp[num] = cal(num-1) + 1;
			}
		}
		
		return dp[num];

	}
}
