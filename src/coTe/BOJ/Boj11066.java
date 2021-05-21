package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11066 {
	
	static int[][] dp;
	static int[] arr;
	static int[] sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
			
			int K = Integer.parseInt(br.readLine());
			
			dp = new int[K][K];
			arr = new int[K];
			sum = new int[K];
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < K ; j++) {
				
				arr[j] = Integer.parseInt(st.nextToken());
				
			}

			sb.append(proc(K)).append('\n');
			
		}
		
		System.out.println(sb);
		
	}
	public static int sum(int a, int b) {
		
		if(a == 0) {
			
			return sum[b];
		}else {

			return sum[b] - sum[a-1];
		}
		 
	}

	public static int proc(int num) {
		
		sum[0] = arr[0];
		
		for(int i = 1 ; i < num; i++) {
			
			sum[i] = sum[i-1] + arr[i];
		}
		for(int i = 0; i < num-1; i++) {
			dp[i][i+1] = arr[i] + arr[i+1];
		}
		
		for(int i = 2; i < num; i++) {
			
			for(int j = 0 ; i+j < num; j++) {
				
				dp[j][i+j] = Integer.MAX_VALUE;
				
				for(int k = j ; k < i+j ; k++) {
					
					dp[j][i+j] = Math.min(dp[j][k] + dp[k+1][i+j] + sum(j,i+j) , dp[j][i+j]);
				
				}
				
			}
			
		}
		
		
		return dp[0][num-1];
	}
	
	
	
}
