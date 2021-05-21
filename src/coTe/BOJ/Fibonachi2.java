package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonachi2 {

	static long[] ans ;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ans = new long[N+1];
		
		for(int i = 0; i < N + 1; i++) {
			
			ans[i] = -1;
		}
			
		ans[0] = 0;
		
		if(N != 0) 
			ans[1] = 1;
		
		System.out.println(fibo(N));
		
	}

	public static long fibo(int num) {
		
		if(ans[num] == -1) {
			
			ans[num] = fibo(num-1) + fibo(num-2);
			
			
		}
		
		return ans[num];

	}
}
