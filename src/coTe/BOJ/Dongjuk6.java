package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dongjuk6 {

	static int[][] top; 
	static Integer[][] sum;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		n = Integer.parseInt(br.readLine());
		
		top = new int[n][n];
		sum = new Integer[n][n];
		
		for(int i = 0; i < n ; i++) {
	
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j <= i ; j++) {
			
				top[i][j] = Integer.parseInt(st.nextToken());
				
			}
			
		}
		
		for( int k = 0 ; k < n ; k++ ) {
			
			sum[n-1][k] = top[n-1][k];
		
		}
		
		System.out.println(cal(0, 0));
		
		
	}

	public static int cal(int idx, int i) {

		if(idx == n-1) {
			
			return sum[idx][i];
					
		}
		if( sum[idx][i] == null ) {
			
			sum[idx][i] = Math.max(cal(idx+1, i),cal(idx+1, i+1 )) + top[idx][i];

		}
//		sum[idx][i] = Math.max(cal(sum[idx+1][i], i),cal(sum[idx+1][i+1], i+1 ) ) + top[idx-1][i];
		
		return sum[idx][i];
		
	}
	
	
	
	
	
	
	
	
}
