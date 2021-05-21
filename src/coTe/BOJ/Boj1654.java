package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1654 {
	
	static int[] arr;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		
		for(int i = 0 ; i < K; i++) {
			
			arr[i] = Integer.parseInt(br.readLine());
			
		}
		
		Arrays.sort(arr);
		
		System.out.println(proc(K, N));
		
	}
	
	public static int proc(int K, int N) {
		
		long start = 1;
		long end = arr[K-1];
		long mid = 0;
		int count = 0;
		
		while(start <= end) {
			count = 0;
			mid = (start + end)/2;
			
			for(int i = 0 ; i < K ; i++) {

				count += (arr[i] / mid);	
				
			}
		
			if(count >= N) {
				
				start = mid + 1;
			
			} else {
				
				end = mid - 1 ;
			}

		}
	
		return (int)end;
	}

}
