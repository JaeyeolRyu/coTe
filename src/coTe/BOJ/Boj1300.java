package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1300 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		long k = Long.parseLong(br.readLine());
		
		System.out.println(proc(N,k));
	}

	public static int proc(long N, long k) {
		
		long start = 1;
		long end = k;
		long mid = 0;
		while(start <= end) {
			
			mid = (start + end)/2;
			int count = 0 ;
			
			for(int i = 1; i < N+1; i++) {
				
				count += Math.min(mid/i , N);
				
			}
			
			if(count < k) {
				
				start = mid+1;
				
			} else {
				
				end = mid-1;
			}
			
		}
		
		return (int)mid;
		
		
	}
	
	
}
