package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9251 {

	static char[] arr1;
	static char[] arr2;
	static int[][]	dp;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr1 = br.readLine().toCharArray();
		arr2 = br.readLine().toCharArray();
		
		dp = new int[arr1.length+1][arr2.length+1];
		
		System.out.println(proc(arr1.length,arr2.length));
		
	}

	public static int proc(int x, int y) {
		
		for(int i = 1 ; i < x+1 ; i++) {
			
			for(int j = 1 ; j < y+1 ; j++) {
				
				if(arr1[i-1] == arr2[j-1]) {
					
					dp[i][j] = dp[i-1][j-1] + 1;
					
				} else {
					
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					
				}
				
				
			}
	
		}
		
		return dp[x][y];
		
	}
	
	
}
