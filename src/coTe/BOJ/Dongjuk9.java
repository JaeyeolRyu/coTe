package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dongjuk9 {

	static long[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		dp = new long[N+1][10];

		for(int i = 0; i <= 9 ; i++) {
			
			dp[1][i] = 1;
			
		}
		
		for(int j = 1; j <= 9 ; j++) {
			
			ans += cal(N,j);
			
		}
		System.out.println(ans%1000000000);
	}
	
	public static long cal(int num, int val) {
		
		if(num == 1) {
			return dp[num][val];
		}
	
		if(dp[num][val] == 0) {
			
			if(val == 0) {
				dp[num][val] = cal(num-1, 1);
			} else if(val == 9) {
				dp[num][val] = cal(num-1, 8);
			} else {
				dp[num][val] = cal(num-1,val-1) + cal(num-1,val+1);
			}
			
		}
		
		return dp[num][val]%1000000000;
		
	}
	
}
