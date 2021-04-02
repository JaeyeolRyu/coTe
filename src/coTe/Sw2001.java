package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw2001 {

	static int[][] arr;
	static int[][] dp;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int h = 1; h < T+1; h++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			dp = new int[N-M+1][N-M+1];
			
			for(int i = 0; i < N ; i++) {
				
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < N; j++) {
					
					arr[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			sb.append("#" + h + " " + dfs()).append("\n");
			
		}

		System.out.println(sb);
	}
	
	public static int dfs() {
		
		int ans = Integer.MIN_VALUE;
		
		for(int i = 0; i < N-M+1; i++) {
			
			for(int j = 0; j < N-M+1; j++) {
				
					for(int k = i ; k < i+M; k++) {
						
						for(int l = j; l < j+M; l++) {
							
							dp[i][j] += arr[k][l];
					
						}
					
					}	
			}
			
		}
		
		for(int i = 0; i < N-M+1; i++) {
			
			for(int j = 0; j < N-M+1; j++) {
				
				ans = Math.max(ans, dp[i][j]);
				
			}
		}
		
		return ans;
	}
	
	
	
	
}
