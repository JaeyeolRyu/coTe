package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11054 {

	static int[] arr;
	static int[] dp1;
	static int[] dp2;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp1 = new int[N];
		dp2 = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int  i = 0; i < N ; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
		}

		for(int j = 0; j < N ; j++) {
			
			dp1[j] = 1;
			dp2[j] = 1;
			
		}
		
		System.out.println(proc(N));
		
	}

	public static int proc(int N) {
		
		for(int i = 1 ; i < N ; i++) {
			
			for(int j = 0 ; j < i ; j++) {
				
				if(arr[i] > arr[j] && dp1[j] + 1 > dp1[i]) {
					
					dp1[i] = dp1[j] + 1;
				
				}
				
			}
			
		}
		
		for(int k = N-1 ; k > 0 ; k--) {
			
			for(int l = N-1 ; l > k; l--) {
				
				if(arr[k] > arr[l] && dp2[l] + 1 > dp2[k]) {
					
					dp2[k] = dp2[l] + 1;
					
				}
				
			}
			
		}
		
		int max = 0;
		int sum = 0;
		for(int i = 0; i < N ; i++) {
			
			sum = dp1[i] + dp2[i] - 1;
			max = Math.max(max, sum);
			
		}
		
		return max;
	}
	
	
	
}
