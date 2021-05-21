package coTe.SW;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw1859 {
	static long MAX = 0;
	static long sum = 0;
	static long[] arr;
	static long idx = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < T+1 ; i++) {
			sum = 0;
			int N = Integer.parseInt(br.readLine());
			arr = new long[N];
			st = new StringTokenizer(br.readLine());
			
			for( int j = 0; j < N; j++) {
				
				arr[j] = Long.parseLong(st.nextToken());
				

			}
			
			sell(0, N);
			sb.append("#" + i + " " + sum).append("\n");
		}

		System.out.println(sb);
	}

	public static void sell(long num, int N) {
		
		for( long j = num; j < N; j++) {
			
			if(MAX <= arr[(int) j]) {
				MAX = arr[(int) j];
				idx = j;
			}
			
		}
		
		MAX = 0;
		
		if(idx == num) {
			
			if(idx < N-1) {
				sell(idx + 1, N);	
			}
			
			return;
		} else {
				
			for(long i = num; i < idx ; i++) {
				
				sum += -arr[(int) i];
			}
			
			sum = sum + (arr[(int) idx]*(idx-num));
			

		}	
		
		if(idx < N-1) {
			sell(idx + 1, N);	
		}
		
		return ;
	}
	
}
