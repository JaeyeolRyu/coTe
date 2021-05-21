package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1920 {
	
	static int[] arr1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr1 = new int[N];
		
		for( int i = 0 ; i < N; i++) {
			
			arr1[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(arr1);
		
		int M = Integer.parseInt(br.readLine());

		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < M; i++) {
			
			int num = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(M, num)).append('\n');
		}
	
		System.out.println(sb);
	}

	public static int binarySearch (int M, int num) {
		
		int first;
		int last;
		int mid;

			first = 0;
			last = arr1.length-1;
			
			
			while(first <= last) {
				mid = (first+last)/2;
				
				if(arr1[mid] == num) {
					
					return 1;
					
				}else {
					
					if(arr1[mid] > num) {
						
						last = mid-1;
					} else {
						first = mid+1;
					}
					
				}
	
			}		
				
		
	
		return 0;
	}
}
