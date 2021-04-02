package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj2565 {
	
	static int[][] arr;
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		dp = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
			
		});
		
		System.out.println(proc(N));
	}

	public static int proc(int N) {
		
		for(int i = 0; i < N ; i++) {
			
			if(dp[i] == 0) {
				
				dp[i] = 1;

				for(int j = 0; j < i; j++) {
					
					if(arr[i][1] > arr[j][1] && dp[j]+1 > dp[i]) {
						
						dp[i] = dp[j]+1 ;
						
					}
					
				}
			
			}
			
		}
		int max = 0;
	
		for(int k = 0; k < N ; k++) {
			
			max = Math.max(max, dp[k]);
			
		}
		
		return (N-max);
	}

}
