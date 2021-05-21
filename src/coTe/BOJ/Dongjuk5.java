package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dongjuk5 {

	static int N;
	static int[][] arr;
	static int[][] sum;
	
	static boolean[] visit = new boolean[3];
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N =  Integer.parseInt(br.readLine());
		
		arr = new int[N][3];
		sum = new int[N][3];
		
		for(int i = 0; i < N; i++ ) {
			
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
				
		}
			sum[0][0] = arr[0][0];
			sum[0][1] = arr[0][1];
			sum[0][2] = arr[0][2];
			
			
			
		System.out.println(Math.min(Math.min(cal(N-1, 0), cal(N-1, 1)) , cal(N-1, 2)));
	}

	public static int cal(int idx, int color) {
		
		if(sum[idx][color] == 0) {
			
			if(color == 0) {
				
				sum[idx][0] = Math.min(cal(idx-1, 1), cal(idx-1, 2)) + arr[idx][0];

			} else if( color == 1) {
				
				sum[idx][1] = Math.min(cal(idx-1, 0), cal(idx-1, 2)) + arr[idx][1];

			} else {
				
				sum[idx][2] = Math.min(cal(idx-1, 0), cal(idx-1, 1)) + arr[idx][2];

			}
		
		}
		
		return sum[idx][color];
				
	}
	
}
