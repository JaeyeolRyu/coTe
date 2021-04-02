package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dongjuk4 {
	
	static long[] arr = new long[101];
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		
		for(int i = 0; i < T; i++) {
			
			int N = Integer.parseInt(br.readLine());
			
			sb.append(cal(N)).append("\n");
		}
		
		System.out.println(sb);
	}

	public static long cal(int N) { 
		
		if(arr[N] == 0) {
			
			arr[N] = cal(N-5) + cal(N-1);
			
		}
		

		return arr[N];
	}
	
	
}
