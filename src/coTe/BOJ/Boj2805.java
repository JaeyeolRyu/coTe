package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2805 {
	
	static int N;
	static int M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N ; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(arr);
		
		System.out.println(proc());
		
		
		
	}

	public static int proc() {
		
		long start = 0;
		long end = arr[N-1];
		long mid = 0;
		long count = 0;
		while(start <= end) {
			
			count = 0;
			mid = (start + end) /2;
			for(int i = 0; i < N; i++) {
				
				if(arr[i]-mid > 0) {
					count += arr[i] - mid;
				}
				
			}
			if(count == M) {
				
				return (int)mid;
			}
			if( count > M ) {
				
				start = mid + 1;
				
			} else {
				
				end = mid - 1;
			}
	
		}
		
		return (int)end;
	}
}
