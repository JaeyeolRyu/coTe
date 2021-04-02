package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2981 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int max = 0;
		for( int i = 0; i < N ; i++ ) {
			
			arr[i]= Integer.parseInt(br.readLine());
			
			max = Math.max(max, arr[i]);
			
		}
		
		for(int j = 2; j < max ; j++) {

			for(int k = 1; k < N-1; k++) {
				
				if(k == N-2 ) {
					
					if(arr[k]%j == arr[k+1]%j) {
						
						sb.append(j).append(" ");
					}
				}
				
				if(arr[k]%j != arr[k+1]%j) {
					
					break;
					
				}
					
			}
			
		}
		
	System.out.println(sb);	
	}

}
